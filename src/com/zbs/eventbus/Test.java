package com.zbs.eventbus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BusinessEventBus businessEventBus = (BusinessEventBus)context.getBean("businessEventBusImpl");
		TestEvent event = new TestEvent();
		event.setName("≤‚ ‘");
		businessEventBus.post(event);
		OtherEvent otherEvent = new OtherEvent();
		otherEvent.setName("otherEvent");
		businessEventBus.post(otherEvent);
	}

}
