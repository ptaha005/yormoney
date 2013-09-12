package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.AccountTypeDao;
import com.codexsoft.yormoney.dao.TransactionDao;
import com.codexsoft.yormoney.domain.AccountType;
import com.codexsoft.yormoney.domain.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl extends HibernateDao<Transaction> implements TransactionDao {
    public TransactionDaoImpl(){
        super(Transaction.class);
    }
}
