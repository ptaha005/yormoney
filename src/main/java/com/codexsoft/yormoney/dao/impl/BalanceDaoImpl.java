package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.BalanceDao;
import com.codexsoft.yormoney.domain.Balance;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDaoImpl extends HibernateDao<Balance> implements BalanceDao {
    public BalanceDaoImpl(){
        super(Balance.class);
    }
}
