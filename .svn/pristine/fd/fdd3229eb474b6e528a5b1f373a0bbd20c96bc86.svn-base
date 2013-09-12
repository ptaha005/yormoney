package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.RoleDao;
import com.codexsoft.yormoney.domain.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends HibernateDao<Role> implements RoleDao {
    public RoleDaoImpl(){
        super(Role.class);
    }

    public Role getByRoleName(String name) {
        return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }
}
