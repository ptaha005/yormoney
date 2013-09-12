package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.RoleDao;
import com.codexsoft.yormoney.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Role findByRoleName(String name){
        return roleDao.getByRoleName(name);
    }

    @Transactional
    public Role findById(Long id){
        return roleDao.read(id);
    }
}
