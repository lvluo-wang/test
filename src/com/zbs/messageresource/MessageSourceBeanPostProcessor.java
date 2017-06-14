package com.zbs.messageresource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maru on 11/18/15.
 */

@Component
public class MessageSourceBeanPostProcessor implements  BeanPostProcessor {
//BeanFactoryPostProcessor,
    //private ArrayList<String> messageSources = new ArrayList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    	System.out.println("postProcessBeforeInitialization==========");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    	System.out.println("postProcessAfterInitialization==========");
        if (bean instanceof ReloadableResourceBundleMessageSource) {
            ((ReloadableResourceBundleMessageSource)bean).setBasenames(MessageSourceBeanFactoryPostProcessor.messageSources.
            		toArray(new String[MessageSourceBeanFactoryPostProcessor.messageSources.size()]));
        }
        
        return bean;
    }

//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
////    	ListableBeanFactory listableBeanFactory = beanFactory;
////    	Set beanSet = new HashSet();    
////    	String[] beans = listableBeanFactory.getBeanDefinitionNames();
////    	CollectionUtils.addAll(beanSet, beans);   
////    	Set<MessageSource> messageSources = new HashSet<>();
//////    	beanSet.forEach(name -> {
//////    		BeanFactory f = beanFactory;
//////            MessageSource m = AnnotationUtils.findAnnotation(f.getType(name.toString()), MessageSource.class);
//////            messageSources.add(m);
//////           
//////        });
////    	 resolveMessageSources(messageSources);
//    	System.out.println("postProcessBeanFactory==========");
//    	String[] beans =  beanFactory.getBeanDefinitionNames();
//    	Set beanSet = new HashSet();
//    	CollectionUtils.addAll(beanSet, beans);
//    	beanSet.forEach(name ->{
//    		MessageSource messageSource = beanFactory.findAnnotationOnBean(name.toString(), MessageSource.class);
//    		resolveMessageSources(messageSource);
//    	});
//    	
//    }
//    
//    private void resolveMessageSources(MessageSource messageSource){
//    	 if (messageSources == null || messageSources.size() == 0) {
//          return;
//       }
//    	 String value = messageSource.value();
//       if (value.endsWith(".properties")) {
//           value = value.substring(0, value.length() - 11);
//       } else if (value.endsWith(".xml")) {
//           value = value.substring(0, value.length() - 4);
//       }
//       
//       this.messageSources.add(value);
//    }

//    private void resolveMessageSources(Set<MessageSource> messageSources) {
//        if (messageSources == null || messageSources.size() == 0) {
//            return;
//        }
//
//        this.messageSources.addAll(messageSources.stream().map(messageSource -> {
//            String value = messageSource.value();
//            if (value.endsWith(".properties")) {
//                value = value.substring(0, value.length() - 11);
//            } else if (value.endsWith(".xml")) {
//                value = value.substring(0, value.length() - 4);
//            }
//
//            return value;
//        }).collect(Collectors.toList()));
//    }

}
