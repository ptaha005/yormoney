package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.TaskDao;
import com.codexsoft.yormoney.domain.Income;
import com.codexsoft.yormoney.domain.Task;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Transactional
    public Task getTaskById(Long id){
        return taskDao.read(id);
    }

    @Transactional
    public void saveOrUpdateTask(Task task){
        taskDao.saveOrUpdate(task);
    }

    @Transactional
    public DatatablesStructure<Task> getTaskByParams(JQueryDataTableParamModel<Task> param, Map<String, Object> criterias){
        return taskDao.getDatatablesListByParams(param, criterias, Task.colsPosition);
    }

    @Transactional
    public List<Task> getTaskListByParams(Map<String, Object> params){
        return taskDao.getListByParams(params);
    }

    @Transactional
    public void deleteTask(Task task){
        taskDao.delete(task);
    }

    @Transactional
    public List<Task> getTasksByDate(Date start , Date end, Long id){
        return taskDao.getTasksByDate(start, end, id);
    }

}
