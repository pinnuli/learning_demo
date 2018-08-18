package com.pinnuli.spring.ioc.beanannotation.javabeased;

/**
 * @author: pinnuli
 * @date: 18-7-29
 */

public class MyDriverManager {

    public MyDriverManager(String url, String userName, String password) {
        System.out.println("url : " + url);
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
    }
}
