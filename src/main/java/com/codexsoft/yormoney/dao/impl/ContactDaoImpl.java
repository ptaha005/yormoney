package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.ContactDao;
import com.codexsoft.yormoney.domain.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl extends HibernateDao<Contact> implements ContactDao {
    public ContactDaoImpl(){
        super(Contact.class);
    }

}
