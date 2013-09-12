package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.EventDao;
import com.codexsoft.yormoney.domain.Event;
import com.codexsoft.yormoney.domain.EventExpenditureLevel;
import com.codexsoft.yormoney.domain.EventExpenditureType;
import com.codexsoft.yormoney.services.EventService;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class EventDaoImpl extends HibernateDao<Event> implements EventDao {

    @Autowired
    private EventService eventService;


    public EventDaoImpl() {
        super(Event.class);
    }

    public List<Event> getListEvents(long userId, long typeId ) {
        String sql = "select ev.id as id, active, eet.id as `eventExpenditureType.id`, eet.name as `eventExpenditureType.name`,\n" +
                "               agreed_spend as `agreedSpend`, date , user_id  as `user.id`, eel.order_level\n" +
                "       from event_expenditure_type eet\n" +
                "       left join event ev on eet.id = ev.event_expenditure_type and ev.user_id = :user_id\n" +
                "       inner join event_expenditure_level eel on  eet.level_id = eel.id\n" +
                "       where type_id = :type_id ;";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setParameter("user_id", userId);
        query.setParameter("type_id", typeId);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<HashMap> res = query.list();
        List<Event> result = new ArrayList<Event>();
        for (HashMap obj : res) {
            Event event = new Event();

            event.setId(obj.get("id") != null ? ((Integer)obj.get("id")).longValue() : null);
            if (event.getId() == null)
                eventService.saveOrUpdateEvent(event);
            event.setActive(obj.get("active") != null ? (Boolean) obj.get("active") : null);
            event.setAgreedSpend(obj.get("agreedSpend") != null ? (Integer) obj.get("agreedSpend") : null);
            event.setDate(obj.get("date") != null ? (Date) obj.get("date") : null);
            EventExpenditureType eet = new EventExpenditureType();
            eet.setId(((BigInteger)obj.get("eventExpenditureType.id")).longValue());
            eet.setName((String) obj.get("eventExpenditureType.name"));
            EventExpenditureLevel eel = new EventExpenditureLevel();
            eel.setOrder(obj.get("order_level") != null ? ((Integer)obj.get("order_level")) : null);
            eet.setLevel(eel);
            event.setEventExpenditureType(eet);

            result.add(event);
        }
        return result;
    }

}
