package strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Message;
import models.Messages;
import models.UserActivity;

public class MultipleUserSameMessageStrategy implements SpamDetectionStrategy
{

	// Scan the messages and return a list of message ids considered as spam
	@Override
	public List<Message> scan(Messages messages) {
		 Map<String, UserActivity> activityMap = new HashMap<>();
	   	 List<Message> spamList = new ArrayList<>();
	   	 
	   	 for (Message message: messages.getMessages())
	   	 {
	   		 if (!activityMap.containsKey(message.getSourceProfileId()))
	   		 {
	   			 activityMap.put(message.getSourceProfileId(),
	   					 new UserActivity(message.getSourceProfileId(), message.getTargetProfileId(),
	   							 message.getTimestamp(), message.getBody().trim(),0,0l));
	   		 }
	   		 else
	   		 {
	   			 // existing profile data found, do some spam check
	   			UserActivity userActivity = activityMap.get(message.getSourceProfileId());
	   			 
	   		 	long lastTime = userActivity.getLastTimeStamp();
	   		 	long thisTime = message.getTimestamp();
	   			 
	   		 	long delta = thisTime - lastTime;
	   			double elapsedInSec = delta / 1000d;
	   			 
	   		 	// within 60 sec, this could be spam, check for duplicate message body
	   		 	if (elapsedInSec <= 60d)
	   		 	{
	   				 // is last targe profile the same as this time?
	   				 String lastTargetUserDataId = userActivity.getTargetProfileId();
	   				 
	   				 if (!lastTargetUserDataId.equals(message.getTargetProfileId()))
	   				 {
	   					 // different target, now check to see if same message body
	   					 String lastBody = userActivity.getLastBody();
	   				 
	   					 if (lastBody.equals(message.getBody()))
	   					 {
	   						 // bang! now we found the SPAM
	   						 spamList.add(message);
	   					 }
	   				 }
	   		 	}
	   			 
	   		 	// update latest info for next time
	   		 	// set message counter to zero as we dont' care about count here
	   		 	activityMap.put(message.getSourceProfileId(),
	   					 new UserActivity(message.getSourceProfileId(), message.getTargetProfileId(),
	   							 message.getTimestamp(), message.getBody().trim(),0,0l));
	   		 }
	   	 }
	   	 
	   	 return spamList;
	}

}
