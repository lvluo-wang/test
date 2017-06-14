package com.zbs.messageresource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MessageSourceBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	  static ArrayList<String> messageSources = new ArrayList<>();
	 
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
    	System.out.println("postProcessBeanFactory==========");
    	String[] beans =  beanFactory.getBeanDefinitionNames();
    	Set beanSet = new HashSet();
    	CollectionUtils.addAll(beanSet, beans);
    	beanSet.forEach(name ->{
    		MessageSource messageSource = beanFactory.findAnnotationOnBean(name.toString(), MessageSource.class);
    		resolveMessageSources(messageSource);
    	});
    	
    }
    
    private void resolveMessageSources(MessageSource messageSource){
    	 if (messageSource == null) {
          return;
       }
    	 String value = messageSource.value();
       if (value.endsWith(".properties")) {
           value = value.substring(0, value.length() - 11);
       } else if (value.endsWith(".xml")) {
           value = value.substring(0, value.length() - 4);
       }
       
       this.messageSources.add(value);
    }	

}
