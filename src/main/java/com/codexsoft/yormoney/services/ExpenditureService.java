package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.CategoryDao;
import com.codexsoft.yormoney.dao.EventDao;
import com.codexsoft.yormoney.dao.ExpenditureDao;
import com.codexsoft.yormoney.dao.ExpenditureTypeDao;
import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.util.datatables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ExpenditureService {

    @Autowired
    private ExpenditureDao expenditureDao;

    @Autowired
    private ExpenditureTypeDao expenditureTypeDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private CategoryDao categoryDao;


    @Transactional
    public void saveOrUpdateExpenditure(Expenditure expenditure) {
        expenditureDao.saveOrUpdate(expenditure);
    }

    @Transactional
    public void deleteExpenditure(Expenditure expenditure){
        expenditureDao.delete(expenditure);
    }

    @Transactional
    public DatatablesStructure<Expenditure> getExpenditureByParams(JQueryDataTableParamModel<Expenditure> param, Map<String, Object> criterias){
        return expenditureDao.getDatatablesListByParams(param, criterias, Expenditure.colsPosition);
    }

    @Transactional
    public DatatablesStructure<Event> getEventByParams(JQueryDataTableParamModel<Event> param, Map<String, Object> criterias){
        return eventDao.getDatatablesListByParams(param, criterias, Event.colsPosition);
    }

    @Transactional
    public Event getEventByParams(Map<String, Object> params){
        return eventDao.getByParams(params);
    }

    @Transactional
    public List<Expenditure> getExpenditureByParams(Map<String, Object> params){
        return expenditureDao.getListByParams(params);
    }

    @Transactional List<Expenditure> getExpendituresByParams(Map<String, Object> params){
        return expenditureDao.getListByParams(params);
    }

    @Transactional
    public void deleteEvent(Event event){
        eventDao.delete(event);
    }


    @Transactional
    public void saveOrUpdateEvent(Event event){
        eventDao.saveOrUpdate(event);
    }


    @Transactional
    public List<ExpenditureType> getExpenditureTypes(){
        return expenditureTypeDao.list();
    }

    @Transactional
    public List<Category> getCategories(){
        return categoryDao.list();
    }

    @Transactional
    public Expenditure getExpenditureById(Long id){
        return expenditureDao.read(id);
    }

    @Transactional
    public Event getEventById(Long id){
        return eventDao.read(id);
    }
}
