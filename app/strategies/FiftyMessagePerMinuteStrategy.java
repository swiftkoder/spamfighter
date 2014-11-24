package strategies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import services.ClassifierService;
import models.Message;
import models.Messages;
import models.UserActivity;

@Component
public class FiftyMessagePerMinuteStrategy implements SpamDetectionStrategy
{
	@Autowired
	ClassifierService classifierService;
	
	@Override
	public List<Message> scan(Messages messages) {
		 Map<String, UserActivity> profileMap = new HashMap<>();
	   	 List<Message> spamList = new ArrayList<>();
	   	 
	   	 for (Message message: messages.getMessages())
	   	 {
	   		 if (!profileMap.containsKey(message.getSourceProfileId()))
	   		 {
	   			 UserActivity userActivity =  new UserActivity(message.getSourceProfileId(), message.getTargetProfileId(),message.getTimestamp(), message.getBody().trim(),1,0l);
	   			 userActivity.setFirstTimeStamp(message.getTimestamp());
	   			 profileMap.put(message.getSourceProfileId(),userActivity);
	   		 }
	   		 else
	   		 {
	   			 // existing profile data found, do some spam check
	   			UserActivity profile = profileMap.get(message.getSourceProfileId());
	   			 
	   		 	long firstTime = profile.getFirstTimeStamp();
	   		 	long thisTime = message.getTimestamp();
	   			 
	   		 	long delta = thisTime - firstTime;
	   			// store delta in millisecond
	   			profile.setHowLongRunning(delta);
	   			profile.setCounter(profile.getCounter()+1);
	   			
	   			// check the message rate now 
	   			double throughput = -1;
	   			if (profile.getHowLongRunning() > 0)
	   				throughput = profile.getCounter() * 60000.0 / profile.getHowLongRunning();
	   			/*
	   			System.out.println("count is " + profile.getCounter());
	   			System.out.println("running time is " + profile.getHowLongRunning() + " milliseconds");
	   			System.out.println("message per minute is " + (int)throughput);
	   			*/
	   			if (throughput >= 50)
	   			{
	   				// now we can check spam 
	   				try {
						boolean isSpam = classifierService.containsSpam(message.getBody());
						
						if (isSpam)
						{
							spamList.add(message);
						}
						
					} catch (IOException e) {
						return null;
					}
	   			}
	   		 }
	   	 }
	   	 
	   	 return spamList;
	}

}
