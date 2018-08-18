package com.pinnuli.spring.transaction.demo1;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */
public interface AccountDAO {

    public void outMoney(String out, Double money);

    public void intMoney(String in, Double money);

}
