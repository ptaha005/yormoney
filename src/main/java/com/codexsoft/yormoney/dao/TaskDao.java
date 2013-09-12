package com.codexsoft.yormoney.dao;

import com.codexsoft.yormoney.domain.Task;

import java.util.Date;
import java.util.List;

public interface TaskDao extends DaoInterface<Task> {

    public List getTasksByDate(Date start, Date end, Long id);
}
