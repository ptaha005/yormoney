package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class CalendarControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(CalendarControllerTest.class);

    @Test
    public void getEventList() throws Exception{
        log.info("Class CalendarController , method - /event}, testing");
        ResultActions resultActions =  this.mockMvc.perform(get("/calendar/event").
                principal(auth).param("start", "1376526340").param("end", "1696526340"));
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
