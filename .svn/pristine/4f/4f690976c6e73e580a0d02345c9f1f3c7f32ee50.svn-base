package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.TaskDao;
import com.codexsoft.yormoney.domain.Task;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TaskDaoImpl extends HibernateDao<Task> implements TaskDao {
    public TaskDaoImpl(){
        super(Task.class);
    }


    public List getTasksByDate(Date startPeriod, Date endPeriod, Long id){
        return sessionFactory.getCurrentSession() .createQuery("from Task  where (((startDate <= :startPeriod) and ( dueDate >= :endPeriod))" +
                "or (startDate BETWEEN :startPeriod and :endPeriod) or (dueDate BETWEEN :startPeriod and :endPeriod)) and (user_id = :id)" ).setDate("startPeriod", startPeriod).setDate("endPeriod", endPeriod).setLong("id", id).list();
    }
}
