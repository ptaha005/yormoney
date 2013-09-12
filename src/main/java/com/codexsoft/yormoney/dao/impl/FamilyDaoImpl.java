package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.FamilyDao;
import com.codexsoft.yormoney.domain.Family;
import org.springframework.stereotype.Repository;

@Repository
public class FamilyDaoImpl extends HibernateDao<Family> implements FamilyDao {

    public FamilyDaoImpl(){
        super(Family.class);
    }
}
