package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.PageDao;
import com.codexsoft.yormoney.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class PageDaoImpl extends HibernateDao<Page> implements PageDao {
    public PageDaoImpl(){
        super(Page.class);
    }
}
