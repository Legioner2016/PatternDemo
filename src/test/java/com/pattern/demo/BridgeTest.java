package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.bridge.EmailMessage;
import com.pattern.demo.structural.core.bridge.EmailMessageSender;
import com.pattern.demo.structural.core.bridge.MessageSender;
import com.pattern.demo.structural.core.bridge.TwitterMessage;
import com.pattern.demo.structural.core.bridge.TwitterMessageSender;

@SpringBootTest
public class BridgeTest {

	@Test
	public void testPattern() {
		MessageSender emailMessageSender = new EmailMessageSender();
		EmailMessage emailMessage = new EmailMessage(emailMessageSender, "email");
		emailMessage.setFrom("1");
		emailMessage.setTo("2");
		assertEquals("message sent by email: from: 1 to: 2\nemail", emailMessage.send());

		MessageSender twitterMessageSender = new TwitterMessageSender();
		TwitterMessage twitterMessage = new TwitterMessage(twitterMessageSender, "twit");
		assertEquals("message sent by twitter: twit", twitterMessage.send());
	}

	//Nothing special
	@Test
	public void testPatternSpring() {

	}

	
}
