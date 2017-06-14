package com.zbs.messageresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

//@Component
public class SystemSettingsImpl {

	    //@Autowired
	    MessageSource messageSource;
	    
	    public String getI18nValue(String key){
	    	 return messageSource.getMessage(key, null, null, LocaleContextHolder.getLocale());
	    }
}
