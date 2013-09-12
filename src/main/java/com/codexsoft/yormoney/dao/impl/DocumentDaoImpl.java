package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.DocumentDao;
import com.codexsoft.yormoney.domain.Document;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDaoImpl extends HibernateDao<Document> implements DocumentDao {

    public DocumentDaoImpl(){
        super(Document.class);
    }
}
