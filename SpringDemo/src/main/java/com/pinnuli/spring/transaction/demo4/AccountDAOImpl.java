package com.pinnuli.spring.transaction.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class AccountDAOImpl extends JdbcDaoSupport implements AccountDAO {
    public AccountDAOImpl(){
        System.out.println("AccountDAOImpl");
    }

    @Override
    public void outMoney(String out, Double money) {
        System.out.println("outmoney");
        String sql = "update account set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql, money, out);
    }

    @Override
    public void intMoney(String in, Double money) {
        System.out.println("inmoney");
        String sql = "update account set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql, money, in);
    }
}
