package com.pinnuli.spring.ioc.injection.service;

import com.pinnuli.spring.ioc.injection.dao.InjectionDAO;
import com.pinnuli.spring.ioc.injection.dao.InjectionDAOImpl;

import javax.smartcardio.ATR;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class InjectionServiceImpl implements InjectionService {
    private InjectionDAO injectionDAO;


    //构造器注入


    /*public InjectionServiceImpl(InjectionDAOImpl injectionDAO) {
        this.injectionDAO = injectionDAO;
    }*/


    //设置注入
    public void setInjectionDAO(InjectionDAO injectionDAO) {
        this.injectionDAO = injectionDAO;
    }

    @Override
    public void save(String arg) {
        System.out.println("Service接收参数：" + arg);
        arg = arg + ":" + this.hashCode();
        injectionDAO.save(arg);
    }

}
