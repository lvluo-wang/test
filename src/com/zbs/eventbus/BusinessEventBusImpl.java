package com.zbs.eventbus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;

@Component
public class BusinessEventBusImpl extends EventBus implements BusinessEventBus, BeanPostProcessor {
	
	@Override
	public void post(BaseEvent event) {
		super.post(event);
	}
	
	/*
	 * bean��ʼ�����
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		if(bean instanceof EnableEventBusSubscription){
			this.register(bean);
		}
		return bean;
	}

	/**
	 * bean��ʼ��ǰ
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		return bean;
	}
}
