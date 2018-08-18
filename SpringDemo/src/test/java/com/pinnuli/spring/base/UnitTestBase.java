package com.pinnuli.spring.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.naming.Context;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class UnitTestBase {
    private ClassPathXmlApplicationContext context;

    private String springXmlpath;

    public UnitTestBase(){

    }

    public UnitTestBase(String springXmlpath){
        this.springXmlpath = springXmlpath;
    }

    @Before
    public void before() {
        if(StringUtils.isEmpty(springXmlpath)){
            springXmlpath = "classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e){
            System.out.println("beansexception");
            e.printStackTrace();

        }
    }

    @After
    public void after(){
        context.destroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        System.out.println("getbean");
        try {
            return (T)context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            System.out.println("getbean");
            return context.getBean(clazz);
        } catch (BeansException e) {
            System.out.println("getbean");
            e.printStackTrace();
            return null;
        }
    }
}
