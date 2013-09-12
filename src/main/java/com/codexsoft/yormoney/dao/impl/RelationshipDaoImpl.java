package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.RelationshipDao;
import com.codexsoft.yormoney.domain.Relationship;
import org.springframework.stereotype.Repository;

@Repository
public class RelationshipDaoImpl extends HibernateDao<Relationship> implements RelationshipDao {
    public RelationshipDaoImpl(){
        super(Relationship.class);
    }
}
