package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.EventDao;
import com.codexsoft.yormoney.dao.TaskDao;
import com.codexsoft.yormoney.dao.TransactionDao;
import com.codexsoft.yormoney.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private TransactionDao transactionDao;
}
