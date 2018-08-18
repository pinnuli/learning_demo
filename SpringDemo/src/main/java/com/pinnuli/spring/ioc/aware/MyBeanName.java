package com.pinnuli.spring.ioc.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */

public class MyBeanName implements BeanNameAware{
    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("MyBeanName: " + name);
    }
}
