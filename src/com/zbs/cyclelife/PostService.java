package com.zbs.cyclelife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostService implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("----����init֮��ִ�еķ���postProcessAfterInitialization----");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		/**instanceof �ж�ǰ���Ƿ��Ǻ��ߵ�һ��ʵ��*/
		if(bean instanceof TeacherService){
			System.out.println("--������init֮ǰ�����޸�bean������ֵ--");
			/*�������ǲ���ֱ��newһ������ ��Ϊbean�������һ������ֱ��ת���Ϳ�����*/
			((TeacherService)bean).setName("Longmanfei");
		}
	    System.out.println("---����init֮ǰִ�еķ���postProcessBeforeInitialization---");
		return bean;
	}

}
