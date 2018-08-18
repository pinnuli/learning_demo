package com.pinnuli.spring.transaction.demo1;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */
public interface AccountService {

    public void transfer(String out, String in, Double money);
}
