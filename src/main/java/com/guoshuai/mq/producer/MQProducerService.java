/*package com.guoshuai.mq.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class MQProducerService {
	
	    @Autowired
	    private JmsMessagingTemplate jmsMessagingTemplate;

	    @Autowired
	    private Queue queue;

	    @Scheduled(fixedDelay = 3000)
	    // 每3s执行1次
	    public void send() {
	        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
	    }
	
}
*/