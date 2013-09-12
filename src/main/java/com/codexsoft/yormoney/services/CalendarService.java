package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.CalendarEventDao;
import com.codexsoft.yormoney.domain.CalendarEvent;
import com.codexsoft.yormoney.domain.Expenditure;
import com.codexsoft.yormoney.domain.Transaction;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CalendarService {

    @Autowired
    private CalendarEventDao calendarEventDao;

    @Transactional
    public List<CalendarEvent> getListCalendarEventByParams(Map<String, Object> params){
        return calendarEventDao.getListByParams(params);
    }

    @Transactional
    public DatatablesStructure<CalendarEvent> getCalendarEventByParams(JQueryDataTableParamModel<CalendarEvent> param, Map<String, Object> criterias){
        return calendarEventDao.getDatatablesListByParams(param, criterias, CalendarEvent.colsPosition);
    }

    @Transactional
    public List<CalendarEvent> getList(){
        return calendarEventDao.list();
    }

    @Transactional
    public List<CalendarEvent> getCalendarEventsByDate(Date start, Date end, Long id){
        return calendarEventDao.getCalendarEventsByDate(start, end, id);
    }
}
