package com.pinnuli.spring.transaction.demo3;

import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDao(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("transfer");
        accountDAO.outMoney(out, money);
        int i = 1 / 0 ;
        accountDAO.intMoney(in, money);
    }
}
