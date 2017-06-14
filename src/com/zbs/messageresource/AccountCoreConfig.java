package com.zbs.messageresource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
@Service
@Configuration
@MessageSource("classpath:config/core.properties")
public class AccountCoreConfig {
    
}