package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.AccountTypeDao;
import com.codexsoft.yormoney.domain.AccountType;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTypeDaoImpl extends HibernateDao<AccountType> implements AccountTypeDao {
    public AccountTypeDaoImpl(){
        super(AccountType.class);
    }
}
