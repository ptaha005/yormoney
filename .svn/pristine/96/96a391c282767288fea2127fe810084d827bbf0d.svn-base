package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.UserDao;
import com.codexsoft.yormoney.domain.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository
public class UserDaoImpl extends HibernateDao<User> implements UserDao {
    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public User getByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
    }

    @Override
    public User getByEmail(String email){
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("email" , email)).uniqueResult();
    }

    @Override
    public User getUserByActivationCode(String activationCode) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("activationCode", activationCode)).uniqueResult();
    }
}
