package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.AddressDao;
import com.codexsoft.yormoney.domain.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends HibernateDao<Address> implements AddressDao {

    public AddressDaoImpl(){
        super(Address.class);
    }
}
