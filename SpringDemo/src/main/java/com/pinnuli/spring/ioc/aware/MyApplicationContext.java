package com.pinnuli.spring.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */

public class MyApplicationContext implements ApplicationContextAware{
    private ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("MyApplicationContext: " + applicationContext.getBean("myApplicationContext").hashCode());
    }
}
