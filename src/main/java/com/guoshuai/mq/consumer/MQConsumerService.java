package com.guoshuai.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.guoshuai.domain.Email;

@Component
public class MQConsumerService {
	
	
	 @JmsListener(destination = "mailbox", containerFactory = "myFactory")
	    public void receiveMessage(Email email) {
	        System.out.println("Received <" + email + ">");
	    }
}
