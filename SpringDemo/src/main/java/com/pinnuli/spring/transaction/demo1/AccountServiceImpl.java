package com.pinnuli.spring.transaction.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDao(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
        System.out.println("setAccountDao");
    }

    //注入事务管理的模板
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }


    @Override
    public void transfer(final String out, final String in, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                System.out.println("transfer");
                accountDAO.outMoney(out, money);
                int i = 1 / 0 ;
                accountDAO.intMoney(in, money);
            }
        });

    }
}
