package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Period;
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
public class DashboardControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(DashboardControllerTest.class);


    @Test
    @Transactional
    @Rollback
    public void task()throws Exception{
        log.info("Class DashboardController, method -/task ,testing");

       for(Period p : Period.values()){
        ResultActions ra = this.mockMvc.perform(get("/dashboard/task").principal(auth).param("period",p.name() ).param("sEcho","1")
                .param("sSearch","")
                .param("iDisplayLength","-1")
                .param("iDisplayStart","0")
                .param("iColumns","4")
                .param("iSortingCols","1")
                .param("iSortCol_0","0")
                .param("sSortDir_0","asc")
                .param("sColumns",""));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
       }
    }

    @Test
    public void event()throws Exception{
        log.info("Class DashboardController, method -/event ,testing");
        for(Period p: Period.values()){
            ResultActions ra = this.mockMvc.perform(get("/dashboard/event").param("sEcho","1")
                    .param("sSearch","")
                    .param("iDisplayLength","-1")
                    .param("iDisplayStart","0")
                    .param("iColumns","4")
                    .param("iSortingCols","1")
                    .param("iSortCol_0","0")
                    .param("sSortDir_0","asc")
                    .param("sColumns","")
                    .param("period",p.name()).principal(auth));


            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Test
    public void transaction()throws Exception{
        log.info("Class DashboardController, method -/transaction ,testing");
        for(Period p :Period.values()){
            ResultActions ra = this.mockMvc.perform(get("/dashboard/transaction").param("sEcho","1")
                .param("sSearch","")
                .param("iDisplayLength","-1")
                .param("iDisplayStart","0")
                .param("iColumns","4")
                .param("iSortingCols","1")
                .param("iSortCol_0","0")
                .param("sSortDir_0","asc")
                .param("sColumns","")
                .param("period",p.name()).principal(auth));
                ra.andExpect(status().isOk());
                ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

}
