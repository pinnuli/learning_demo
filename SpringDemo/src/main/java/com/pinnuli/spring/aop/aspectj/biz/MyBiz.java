package com.pinnuli.spring.aop.aspectj.biz;

import org.springframework.stereotype.Service;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

@Service
public class MyBiz {

    public String save(String arg) {
        System.out.println("MoocBiz save : " + arg);
//		throw new RuntimeException(" Save failed!");
        return " Save success!";
    }

}
