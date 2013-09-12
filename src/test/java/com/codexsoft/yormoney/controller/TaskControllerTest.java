package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.TaskService;
import com.codexsoft.yormoney.services.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import com.codexsoft.yormoney.domain.Task;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class TaskControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(TaskControllerTest.class);

    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @Test
    @Transactional
    @Rollback
    public void add() throws Exception {
        log.info("Class TaskController, method - /add, testing");
        String requestJson = "{\"title\":\"first\",\"startDate\":\"2013-9-10\",\"dueDate\":\"2013-9-10\",\"complete\":20,\"reminder\":1,\"notes\":[],\"linkTo\":\"Ivan Ivanov\"}";
        ResultActions ra = this.mockMvc.perform(post("/task/add").content(requestJson).contentType(MediaType.APPLICATION_JSON).principal(auth));
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
    }

    @Test
    public void init() throws Exception {
        log.info("Class TaskController, method - /init, testing");
        ResultActions ra = this.mockMvc.perform(get("/task/init").principal(auth));
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
    }
    @Test
    public void listTask() throws Exception {
        log.info("Class TaskController, method - /listTask, testing");
        ResultActions ra = this.mockMvc.perform(get("/task/listTask").param("sEcho","1")
                .param("sSearch","")
                .param("iDisplayLength","10")
                .param("iDisplayStart","0")
                .param("iColumns","7")
                .param("iSortingCols","1")
                .param("iSortCol_0","0")
                .param("sSortDir_0","asc")
                .param("sColumns","").principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void initByParam() throws Exception {
        log.info("Class TaskController, method - /init{id}, testing");
        Task task = new Task();
        task.setComplete(20);
        task.setDueDate(new Date());
        task.setLinkTo("linkTo");
        task.setReminder(12);
        task.setStartDate(new Date());
        task.setTitle("title");
        taskService.saveOrUpdateTask(task);
        User user = userService.findByUsername(username);
        task.setUser(user);
        taskService.saveOrUpdateTask(task);

        ResultActions ra = this.mockMvc.perform(get("/task/init/"+task.getId()).principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void delete() throws Exception {
        log.info("Class TaskController, method - /delete, testing");
        Task task = new Task();
        task.setComplete(20);
        task.setDueDate(new Date());
        task.setLinkTo("linkTo");
        task.setReminder(12);
        task.setStartDate(new Date());
        task.setTitle("title");
        taskService.saveOrUpdateTask(task);
        User user = userService.findByUsername(username);
        task.setUser(user);
        taskService.saveOrUpdateTask(task);

        ResultActions ra = this.mockMvc.perform(post("/task/delete").content("{\"id\" : \""+task.getId()+"\"}").principal(auth)
        .contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }



}
