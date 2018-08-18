package com.pinnuli.spring.aop.api;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class BizLogicImpl implements BizLogic{

    @Override
    public String save() throws RuntimeException {
        System.out.println("BizLogicImpl : BizLogicImpl save.");
        return "BizLogicImpl save.";
//		throw new RuntimeException();
    }
}
