package com.pinnuli.spring.ioc.beanannotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

@Repository
public class InjectionDAOImpl implements InjectionDAO {
    @Override
    public void save(String arg) {
       System.out.println("保存数据：" + arg);
    }
}
