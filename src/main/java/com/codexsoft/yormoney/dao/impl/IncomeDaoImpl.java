package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.IncomeDao;
import com.codexsoft.yormoney.domain.Income;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeDaoImpl extends HibernateDao<Income> implements IncomeDao {
    public IncomeDaoImpl(){
        super(Income.class);
    }
}
