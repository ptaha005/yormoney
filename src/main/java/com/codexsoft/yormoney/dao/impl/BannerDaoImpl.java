package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.BannerDao;
import com.codexsoft.yormoney.domain.Banner;
import org.springframework.stereotype.Repository;

@Repository
public class BannerDaoImpl extends HibernateDao<Banner> implements BannerDao {
    public BannerDaoImpl(){
        super(Banner.class);
    }
}
