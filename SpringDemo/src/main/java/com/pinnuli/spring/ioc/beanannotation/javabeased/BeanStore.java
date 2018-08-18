package com.pinnuli.spring.ioc.beanannotation.javabeased;

/**
 * @author: pinnuli
 * @date: 18-7-29
 */

public class BeanStore implements Store<String>{

    public void init() {
        System.out.println("This is init.");
    }

    public void destory() {
        System.out.println("This is destroy.");
    }
}
