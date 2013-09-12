package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.BankDao;
import com.codexsoft.yormoney.domain.Bank;
import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl extends HibernateDao<Bank> implements BankDao {
    public BankDaoImpl(){
        super(Bank.class);
    }
}
