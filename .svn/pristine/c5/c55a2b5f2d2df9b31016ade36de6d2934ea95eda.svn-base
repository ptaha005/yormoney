package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.AccountTypeDao;
import com.codexsoft.yormoney.dao.BankAccountDao;
import com.codexsoft.yormoney.dao.BankDao;
import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.util.datatables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Autowired
    private BankDao bankDao;

    @Autowired
    private AccountTypeDao accountTypeDao;


    @Transactional
    public void saveOrUpdateBankAccount(BankAccount bankAccount) {
        bankAccountDao.saveOrUpdate(bankAccount);
    }

    @Transactional
    public void mergeBankAccount(BankAccount bankAccount){
        bankAccountDao.merge(bankAccount);
    }

    @Transactional
    public DatatablesStructure<BankAccount> getBankAccountByParams(JQueryDataTableParamModel<BankAccount> param, Map<String, Object> criterias){
        return bankAccountDao.getDatatablesListByParams(param, criterias, BankAccount.colsPosition);
    }

    @Transactional
    public List<BankAccount> getListBankAccountByParams(Map<String, Object> params){
        return bankAccountDao.getListByParams(params);
    }

    @Transactional
    public BankAccount getBankAccountById(Long id){
        return bankAccountDao.read(id);
    }

    @Transactional
    public void deleteBankAccount(BankAccount bankAccount){
        bankAccountDao.delete(bankAccount);
    }

    @Transactional
    public Bank getBankById(Long id){
        return bankDao.read(id);
    }

    @Transactional
    public List<Bank> getBankList(){
        return bankDao.list();
    }

    @Transactional
    public List<AccountType> getAccountTypeList(){
        return accountTypeDao.list();
    }


}
