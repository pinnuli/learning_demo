package com.pinnuli.spring.ioc.bean;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class BeanScope {
    public void say(){
        System.out.println("BeanScope say: " + this.hashCode());
    }
}
