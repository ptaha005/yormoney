package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.ContactDao;
import com.codexsoft.yormoney.domain.Contact;
import com.codexsoft.yormoney.domain.Task;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;


    @Transactional
    public Contact getContactById(Long id){
        return contactDao.read(id);
    }

    @Transactional
    public void saveOrUpdateContact(Contact contact){
        contactDao.saveOrUpdate(contact);
    }

    @Transactional
    public List<Contact> getContactListByParams(Map<String, Object> params){
        return contactDao.getListByParams(params);
    }

    @Transactional
    public DatatablesStructure<Contact> getTaskByParams(JQueryDataTableParamModel<Contact> param, Map<String, Object> criterias){
        return contactDao.getDatatablesListByParams(param, criterias, Contact.colsPosition);
    }

    @Transactional
    public void deleteContact(Contact contact){
        contactDao.delete(contact);
    }
}
