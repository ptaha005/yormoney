package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.DaoInterface;
import com.codexsoft.yormoney.domain.DomainObject;
import com.codexsoft.yormoney.util.datatables.*;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HibernateDao<T extends DomainObject> implements DaoInterface<T>{

    private Class<T> _class;
    private static Logger logger = Logger.getLogger(HibernateDao.class);

    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateDao(Class<T> _class) {
        this._class = _class;
    }


    public HibernateDao() {
    }

    public void merge(T item){
        Session session = sessionFactory.getCurrentSession();
        session.merge(item);
        session.flush();
    }

    public void saveOrUpdate(T item) {
        Session session = sessionFactory.getCurrentSession();
//        if (item instanceof Billingable && item.getId() == null){
//            Billingable bItem = (Billingable) item;
//            ((Billingable) item).setCreatedDate(new Date());
//        }
        session.saveOrUpdate(item);
        session.flush();
    }

    public void saveOrUpdate(List<T> items) {
        Session session = sessionFactory.getCurrentSession();
        for (T item : items) session.saveOrUpdate(item);
        session.flush();
    }

    public T read(Long id, Class clazz) {
        return (T) sessionFactory.getCurrentSession().
                createCriteria(clazz)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public T read(Long id) {
        return (T) sessionFactory.getCurrentSession().
                createCriteria(_class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public void delete(T item) {
//        if(item instanceof Billingable){
//            Billingable bItem = (Billingable) item;
//            bItem.setDeletedFlag(true);
//            saveOrUpdate(item);
//        } else {
            sessionFactory.getCurrentSession().delete(item);
//        }
    }

    public List<T> list() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        return (List<T>) criteria.list();
    }

    public List<T> list(int first, int count) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        criteria.setFirstResult(first);
        criteria.setMaxResults(count);

        return (List<T>) criteria.list();
    }

    public List<T> sortedList(int first, int count, String orderField, String orderDirection) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        if (orderField != null) {

            if (orderDirection == null) {
                orderDirection = "asc";
            }

            if (orderDirection.equals("desc")) {
                criteria.addOrder(Order.desc(orderField));
            } else {
                criteria.addOrder(Order.asc(orderField));
            }
        }
        criteria.setFirstResult(first);
        criteria.setMaxResults(count);

        return (List<T>) criteria.list();
    }

    private List<T> sortedList(int first, int count, String orderField, String orderDirection,
                               String searchQuery, Criteria criteria) {
        if (criteria == null) {
            criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        } else if(searchQuery != null && searchQuery.length() > 1) {
            criteria.add(Restrictions.disjunction()
                    .add(Restrictions.ilike("firstName", searchQuery, MatchMode.ANYWHERE))
                    .add(Restrictions.ilike("lastName", searchQuery, MatchMode.ANYWHERE))
                    .add(Restrictions.ilike("email", searchQuery, MatchMode.ANYWHERE))
            );
        }
        if (orderField != null) {
            if (orderDirection == null) {
                orderDirection = "asc";
            }

            if (orderDirection.equals("desc")) {
                criteria.addOrder(Order.desc(orderField));
            } else {
                criteria.addOrder(Order.asc(orderField));
            }
        }
        criteria.setFirstResult(first);
        criteria.setMaxResults(count);
        return (List<T>) criteria.list();
    }

    public DatatablesStructure<T> getDatatablesListByParams(JQueryDataTableParamModel<T> param, Map<String, Object> criterias, String[] colsPosition) {
        DatatablesStructure<T> data = new DatatablesStructure<T>();
        int start = param.iDisplayStart;
        int lenght = param.iDisplayLength;
        String sortColumn = param.iSortColumnIndex >= 0 ? colsPosition[param.iSortColumnIndex] : null;
        String sortDirection = param.sSortDirection;
        String searchQuery = param.sSearch;
        List<T> resultList = sortedList(start, lenght, sortColumn, sortDirection, searchQuery,
                getCriteria(criterias));
        Hibernate.initialize(resultList);
        Long size = size(getCriteria(criterias));
        Long searchSize = sizeOfUsersList(searchQuery);
        if(searchSize != null && !size.equals(searchSize)) {
            size = searchSize;
        }
        data.setTotalDisplayRecords(size.intValue());
        data.setTotalRecords(size.intValue());
        data.setEcho(param.sEcho);
        data.setData(resultList);
        return data;
    }


    public DatatablesStructure<T> getDatatablesListByData(List<T> resultList, JQueryDataTableParamModel<T> param) {
        DatatablesStructure<T> data = new DatatablesStructure<T>();
        data.setTotalDisplayRecords(resultList.size());
        data.setTotalRecords(resultList.size());
        data.setEcho(param.sEcho);
        data.setData(resultList);
        return data;
    }

    protected Criteria getCriteria(Map<String, Object> criterias) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        if (criterias != null && criterias.size() > 0) {
            Map<String, Object> equalParams = (Map<String, Object>)criterias.get("equalParams");
            Map<String, Object> aliasParams = (Map<String, Object>) criterias.get("aliasParams");
            Map<String, Object> notEqualParams = (Map<String, Object>)criterias.get("notEqualParams");
            Map<String, Object> notNullParam = (Map<String, Object>)criterias.get("notNullParam");
            Map<String, Object> isNullParam = (Map<String, Object>)criterias.get("isNullParam");
            Map<String, Object> inParam = (Map<String, Object>)criterias.get("inParam");
            Map<String, Object> order = (Map<String, Object>)criterias.get("orderParam");
            Map<String, Object> greatThan = (Map<String, Object>)criterias.get("greatThanParams");
            Map<String, Object> lessThan = (Map<String, Object>) criterias.get("lessThan");
            Map<String, Object> like = (Map<String, Object>) criterias.get("like");
            Map<String, Object> or = (Map<String, Object>) criterias.get("or");


            Class actualClass = this.getClass();
            ParameterizedType type = (ParameterizedType)actualClass.getGenericSuperclass();
            Class parameter = (Class)type.getActualTypeArguments()[0];

            for (String key : aliasParams.keySet()){
                String[] str = key.split("\\.");
                Criteria tempCriteria = criteria.createCriteria(str[0]);
                for (int i = 1; i < str.length-1; i++)
                    tempCriteria = tempCriteria.createCriteria(str[i]);
                tempCriteria.add(Restrictions.eq(str[str.length - 1], aliasParams.get(key)));
            }


            for (String key : equalParams.keySet()) {
                criteria.add(Restrictions.eq(key, equalParams.get(key)));
            }

            for (String key : notNullParam.keySet()) {
                criteria.add(Restrictions.isNotNull(key));
            }

            for (String key : isNullParam.keySet()) {
                criteria.add(Restrictions.isNull(key));
            }

            for (String key : inParam.keySet()) {
                criteria.add(Restrictions.in(key, (Collection) inParam.get(key)));
            }

            for (String key : notEqualParams.keySet()) {
                criteria.add(Restrictions.ne(key, notEqualParams.get(key)));
            }

            for (String key : order.keySet()) {
                String orderDirection = (String)order.get(key);
                if(orderDirection.equals("asc")){
                    criteria.addOrder(Order.asc(key));
                } else if(orderDirection.equals("desc")){
                    criteria.addOrder(Order.desc(key));
                }
            }

            for(String key : greatThan.keySet()) {
                criteria.add(Restrictions.ge(key, greatThan.get(key)));
            }

            for(String key : lessThan.keySet()){
                criteria.add(Restrictions.lt(key, lessThan.get(key)));
            }

            for(String key : like.keySet()){
                criteria.add(Restrictions.like(key, (String)like.get(key), MatchMode.EXACT));
            }
        }
        return criteria;
    }

    private Long sizeOfUsersList(String searchQuery) {
        if(searchQuery == null || searchQuery.length() < 2) {
            return null;
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        criteria.add(Restrictions.disjunction()
                .add(Restrictions.ilike("firstName", searchQuery, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("lastName", searchQuery, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("email", searchQuery, MatchMode.ANYWHERE))
        );
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public Long size() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(_class.getCanonicalName());
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public Long size(Criteria criteria) {
        if (criteria != null) {
            criteria.setProjection(Projections.rowCount());
            return (Long) criteria.uniqueResult();
        } else {
            return size();
        }
    }

    @Override
    public Long size(Map<String, Object> criterias) {
        Criteria criteria = getCriteria(criterias);
        return size(criteria);
    }

    public void evict(T item) {
        Session session = sessionFactory.getCurrentSession();
        session.evict(item);
    }

    @Override
    public T getByParams(Map<String, Object> params) {
        Criteria criteria = getCriteria(params);
        return (T) criteria.uniqueResult();
    }

    @Override
    public List<T> getListByParams(Map<String, Object> params) {
        Criteria criteria = getCriteria(params);
        return (List<T>) criteria.list();
    }

    @Override
    public Long getListCountByParams(Map<String, Object> params) {
        Criteria criteria = getCriteria(params);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }
}
