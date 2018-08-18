package com.pinnuli.spring.aop.schema.advice;

/**
 * @author: pinnuli
 * @date: 18-8-14
 */

public class FitImpl implements Fit{
    @Override
    public void filter() {
        System.out.println("FitImpl filter.");
    }
}
