package com.zbs.cyclelife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostService implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("----这是init之后执行的方法postProcessAfterInitialization----");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		/**instanceof 判断前者是否是后者的一个实例*/
		if(bean instanceof TeacherService){
			System.out.println("--这是在init之前进行修改bean的属性值--");
			/*这里我们不能直接new一个对象 因为bean本身就是一个对象，直接转换就可以了*/
			((TeacherService)bean).setName("Longmanfei");
		}
	    System.out.println("---这是init之前执行的方法postProcessBeforeInitialization---");
		return bean;
	}

}
