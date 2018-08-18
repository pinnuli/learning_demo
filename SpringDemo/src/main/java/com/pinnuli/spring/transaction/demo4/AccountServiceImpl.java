package com.pinnuli.spring.transaction.demo4;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDao(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("transfer");
        accountDAO.outMoney(out, money);
//        int i = 1 / 0 ;
        accountDAO.intMoney(in, money);
    }
}
