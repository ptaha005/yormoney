package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.*;
import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class InsuranceService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private InsuranceDao insuranceDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private InsuranceCompanyDao insuranceCompanyDao;

    @Autowired
    private PhoneDao phoneDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private EmailDao emailDao;

    @Transactional
    public void saveOrUpdateInsurance(Insurance insurance) {
        insuranceDao.saveOrUpdate(insurance);
    }

    @Transactional
    public DatatablesStructure<Transaction> getPaymentByParams(JQueryDataTableParamModel<Transaction> param, Map<String, Object> criterias){
        return transactionDao.getDatatablesListByParams(param, criterias, Transaction.colsPosition);
    }

    @Transactional
    public Insurance getInsuranceByParams(Map<String, Object> params){
        return insuranceDao.getByParams(params);
    }

    @Transactional
    public List<InsuranceCompany> getListInsuranceCompanies(){
        return insuranceCompanyDao.list();
    }

    @Transactional
    public void saveOrUpdateCompany(Company company){
        companyDao.saveOrUpdate(company);
    }

    @Transactional
    public Phone getPhoneById(Long id){
        return phoneDao.read(id);
    }

    @Transactional
    public Address getAddressById(Long id){
        return addressDao.read(id);
    }

    @Transactional
    public void saveOrUpdateAddress(Address address){
        addressDao.saveOrUpdate(address);
    }

    @Transactional
    public void saveOrUpdatePhone(Phone phone){
        phoneDao.saveOrUpdate(phone);
    }

    @Transactional
    public void deletePhone(Phone phone){
        phoneDao.delete(phone);
    }

    @Transactional
    public void deleteAddress(Address address){
        addressDao.delete(address);
    }

    @Transactional
    public DatatablesStructure<Phone> getPhoneByParams(JQueryDataTableParamModel<Phone> param, Map<String, Object> criterias){
        return phoneDao.getDatatablesListByParams(param, criterias, Phone.colsPosition);
    }

    @Transactional
    public DatatablesStructure<Address> getAddressByParams(JQueryDataTableParamModel<Address> param, Map<String, Object> criterias){
        return addressDao.getDatatablesListByParams(param, criterias, Address.colsPosition);
    }

    @Transactional
    public List<Transaction> getPaymentListByParams(Map<String, Object> params){
        return transactionDao.getListByParams(params);
    }

    @Transactional
    public Email getEmailById(Long id){
        return emailDao.read(id);
    }

    @Transactional
    public void saveOrUpdateEmail(Email email){
        emailDao.saveOrUpdate(email);
    }

    @Transactional
    public void deleteEmail(Email email){
        emailDao.delete(email);
    }

    @Transactional
    public DatatablesStructure<Email> getEmailByParams(JQueryDataTableParamModel<Email> param, Map<String, Object> criterias){
        return emailDao.getDatatablesListByParams(param, criterias, Email.colsPosition);
    }

}
