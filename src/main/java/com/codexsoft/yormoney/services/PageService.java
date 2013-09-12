package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.PageDao;
import com.codexsoft.yormoney.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PageService {

    @Autowired
    private PageDao pageDao;

    @Transactional
    public Page gePageById(Long id){
        return pageDao.read(id);
    }

    @Transactional
    public Page getPageByParams(Map<String, Object> params){
        return pageDao.getByParams(params);
    }

    @Transactional
    public List<Page> getPage(){
        return pageDao.list();
    }
}
