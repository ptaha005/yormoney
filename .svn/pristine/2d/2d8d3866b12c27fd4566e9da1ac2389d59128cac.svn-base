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
public class EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private EventExpenditureTypeDao eventExpenditureTypeDao;

    @Transactional
    public List<Event> getListEvents(long userId, long typeId){
        return  eventDao.getListEvents(userId, typeId);
    }

    @Transactional
    public List<Event> getList(){
        return  eventDao.list();
    }

    @Transactional
    public Event getEventById(Long id){
        return eventDao.read(id);
    }

    @Transactional
    public EventExpenditureType getEventExpenditureTypeById(Long id){
        return eventExpenditureTypeDao.read(id);
    }

    @Transactional
    public DatatablesStructure<Event> getEventByParams(long userId, long typeId, JQueryDataTableParamModel<Event> param) {
        List<Event> eventList = eventDao.getListEvents(userId, typeId);
        return eventDao.getDatatablesListByData(eventList, param);
    }

    @Transactional
    public void saveOrUpdateEvent(Event expenditure) {
        eventDao.saveOrUpdate(expenditure);
    }

    @Transactional
    public void deleteEvent(Event expenditure){
        eventDao.delete(expenditure);
    }

}
