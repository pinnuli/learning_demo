package com.pinnuli.spring.ioc.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */
@Scope
@Component
public class BeanAnnotation {

    public void say(String arg){
        System.out.println("BeanAnnotation:" + arg);
    }

}
