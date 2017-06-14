package com.zbs.eventbus;

import org.springframework.stereotype.Service;

import com.google.common.eventbus.Subscribe;

@Service
public class OtherEventBusServiceImpl implements EnableEventBusSubscription {
	
	@Subscribe
	public void otherEventBus(OtherEvent otherEvent){
		System.out.println("otherEventBus");
		
	}

}
