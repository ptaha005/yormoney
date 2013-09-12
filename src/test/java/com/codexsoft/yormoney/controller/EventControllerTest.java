package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class EventControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(EventControllerTest.class);

    @Test
    @Transactional
    @Rollback
    public void addEvent() throws Exception{
        log.info("Class EventController, method - /add, testing");
        String content = "{\"agreedSpend\" : \"9090\",\"date\" : \"2000-02-28\", \"user\":{\"id\" : \"1\"}}";
        ResultActions ra = this.mockMvc.perform(post("/event/add").
                content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getEvents()throws Exception{
        log.info("Class EventController, method - /plainlist/{type}, testing");
        ResultActions ra = this.mockMvc.perform(get("/event/plainlist/{type}",0).principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }



}
