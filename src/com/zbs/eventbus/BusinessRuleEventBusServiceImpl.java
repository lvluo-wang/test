package com.zbs.eventbus;

import org.springframework.stereotype.Service;

import com.google.common.eventbus.Subscribe;

@Service
public class BusinessRuleEventBusServiceImpl implements EnableEventBusSubscription{

	@Subscribe
    public void handleBusinessRuleEvent(TestEvent event) {
        System.out.println(event.toString());
        }
	
}
