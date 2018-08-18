package com.pinnuli.spring.aop.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

@Component
@Aspect
public class MyAspectj {

    @Pointcut("execution(* com.pinnuli.spring.aop.aspectj.biz.*Biz.*(..))")
    public void pointcut() {}

    @Pointcut("within(com.pinnuli.spring.aop.aspectj.biz.*)")
    public void bizPointcut() {}

    @Before("execution(* com.pinnuli.spring.aop.aspectj.biz.*Biz.*(..))")
    public void before() {
        System.out.println("Before.");
    }

    @AfterReturning(pointcut="bizPointcut()", returning="returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("AfterReturning : " + returnValue);
    }
}
