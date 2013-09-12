package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.InsuranceDao;
import com.codexsoft.yormoney.domain.Insurance;
import org.springframework.stereotype.Repository;

@Repository
public class InsuranceDaoImpl extends HibernateDao<Insurance> implements InsuranceDao {

    public InsuranceDaoImpl(){
        super(Insurance.class);
    }
}
