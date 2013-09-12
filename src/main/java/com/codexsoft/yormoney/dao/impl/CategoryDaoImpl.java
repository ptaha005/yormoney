package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.CategoryDao;
import com.codexsoft.yormoney.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends HibernateDao<Category> implements CategoryDao {
    public CategoryDaoImpl(){
        super(Category.class);
    }
}
