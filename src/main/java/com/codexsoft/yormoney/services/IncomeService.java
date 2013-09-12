package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.IncomeCategoryDao;
import com.codexsoft.yormoney.dao.IncomeDao;
import com.codexsoft.yormoney.dao.IncomeTypeDao;
import com.codexsoft.yormoney.domain.Income;
import com.codexsoft.yormoney.domain.IncomeCategory;
import com.codexsoft.yormoney.domain.IncomeType;
import com.codexsoft.yormoney.util.datatables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class IncomeService {

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private IncomeTypeDao incomeTypeDao;

    @Autowired
    private IncomeCategoryDao incomeCategoryDao;

    @Transactional
    public Income getIncomeById(Long id){
        return incomeDao.read(id);
    }

    @Transactional
    public void saveOrUpdateIncome(Income income) {
        incomeDao.saveOrUpdate(income);
    }

    @Transactional
    public DatatablesStructure<Income> getIncomeByParams(JQueryDataTableParamModel<Income> param, Map<String, Object> criterias){
        return incomeDao.getDatatablesListByParams(param, criterias, Income.colsPosition);
    }

    @Transactional
    public List<Income> getIncomesByParams(Map<String, Object> params){
        return incomeDao.getListByParams(params);
    }

    @Transactional
    public void deleteIncome(Income income){
        incomeDao.delete(income);
    }

    @Transactional
    public List<IncomeType> getIncomeTypes(){
        return incomeTypeDao.list();
    }

    @Transactional
    public List<IncomeType> getIncomeTypesByParams(Map<String, Object> params){
        return incomeTypeDao.getListByParams(params);
    }

    @Transactional
    public void deletedIncomeType(IncomeType incomeType){
        incomeTypeDao.delete(incomeType);
    }

    @Transactional
    public List<IncomeCategory> getIncomeCategory(){
        return incomeCategoryDao.list();
    }

    @Transactional
    public IncomeCategory getIncomeCategoryById(Long incomeCategoryId){
        return incomeCategoryDao.read(incomeCategoryId);
    }
}
