package com.pinnuli.spring.ioc.interfaces;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class OneInterfaceImpl implements OneInterface {
    @Override
    public void say(String arg) {
       System.out.println("ServiceImpl: " + arg);
    }
}
