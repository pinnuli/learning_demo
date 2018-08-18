package com.pinnuli.spring.ioc.injection.dao;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class InjectionDAOImpl implements InjectionDAO {
    @Override
    public void save(String arg) {
       System.out.println("保存数据：" + arg);
    }
}
