

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.Messages;

import org.junit.BeforeClass;
import org.junit.Test;

import services.SpamFilterService;
import services.SpamFilterServiceImpl;

public class SpamTests {

	private static SpamFilterService service;
	
	@BeforeClass
	public static void oneTimeSetup()
	{
		service = new SpamFilterServiceImpl();
	}
	
	@Test
	public void testFifty()
	{
		List<Message> messages = new ArrayList<>();
		// send fifty message per minute
		long lastTime = System.currentTimeMillis();
		for (int i=0; i < 50; i++)
		{
			lastTime = lastTime+1200;
			Message msg = new Message();
			msg.setTimestamp(lastTime);
			msg.setSourceProfileId("s1");
			msg.setTargetProfileId("t1");
			msg.setBody("spambody");
			messages.add(msg);
		}
		
		Messages msg = new Messages();
		msg.setMessages(messages);
		List idList = service.analyze(msg, "fifty");
		assertEquals(0, idList.size());
	}
	
	
	@Test
	public void testNoSpam() {
		
		List<Message> messages = new ArrayList<>();
		
		// test no spam
		Message m1 = new Message();
		m1.setSourceProfileId("s1");
		m1.setBody("beach");
		m1.setTimestamp(System.currentTimeMillis());
		m1.setTargetProfileId("t1");
		
		Message m2 = new Message();
		m2.setSourceProfileId("s1");
		m2.setBody("beach");
		m2.setTimestamp(System.currentTimeMillis());
		m2.setTargetProfileId("t1");
		
		messages.add(m1);
		messages.add(m2);
		
		Messages msg = new Messages();
		msg.setMessages(messages);
		
		List spamList = service.analyze(msg, "multiuser");
		
		assertEquals(spamList.size(), 0);
	}
	
	@Test
	public void testSpam() {
		
		List<Message> messages = new ArrayList<>();
		
		// test no spam
		Message m1 = new Message();
		m1.setSourceProfileId("s1");
		m1.setBody("beach");
		m1.setTimestamp(System.currentTimeMillis());
		m1.setTargetProfileId("t1");
		
		Message m2 = new Message();
		m2.setSourceProfileId("s1");
		m2.setBody("beach");
		m2.setTimestamp(System.currentTimeMillis()+ 120000);
		m2.setTargetProfileId("t2");
		
		messages.add(m1);
		messages.add(m2);
		
		Messages msg = new Messages();
		msg.setMessages(messages);
		
		List spamList = service.analyze(msg, "multiuser");
		
		assertEquals(1,spamList.size());
	}

}
