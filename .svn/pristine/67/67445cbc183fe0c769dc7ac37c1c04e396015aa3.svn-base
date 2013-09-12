package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.CalendarEventDao;
import com.codexsoft.yormoney.domain.CalendarEvent;
import com.codexsoft.yormoney.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CalendarEventDaoImpl extends HibernateDao<CalendarEvent> implements CalendarEventDao {
    public CalendarEventDaoImpl(){
        super(CalendarEvent.class);
    }

    public List getCalendarEventsByDate(Date startPeriod, Date endPeriod, Long id){
        return sessionFactory.getCurrentSession() .createQuery("from CalendarEvent  where (((start <= :startPeriod) and ( endDate >= :endPeriod))" +
                "or (start BETWEEN :startPeriod and :endPeriod) or (endDate BETWEEN :startPeriod and :endPeriod)) and (user_id = :id)" ).setDate("startPeriod", startPeriod).setDate("endPeriod", endPeriod).setLong("id", id).list();
    }
}
