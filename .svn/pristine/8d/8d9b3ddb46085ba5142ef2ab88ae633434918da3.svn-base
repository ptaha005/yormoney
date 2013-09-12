package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Expenditure;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.ExpenditureService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
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


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class ExpenditureControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(ExpenditureControllerTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenditureService expenditureService;

    @Test
    public void getExpenditureTypes() throws Exception{
        log.info("Class ExpenditureController, method - /expenditurestypes, testing");
        ResultActions ra = this.mockMvc.perform(get("/expenditure/expendituretypes"));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getCategories() throws Exception{
        log.info("Class ExpenditureController, method - /categories, testing");
        ResultActions ra = this.mockMvc.perform(get("/expenditure/categories"));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getFrequency() throws Exception{
        log.info("Class ExpenditureController, method - /frequency/list, testing");
        ResultActions ra = this.mockMvc.perform(get("/expenditure/frequency/list"));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getDay() throws Exception{
        log.info("Class ExpenditureController, method - /day/list, testing");
        ResultActions ra = this.mockMvc.perform(get("/expenditure/day/list"));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void addExpenditure() throws Exception{
        log.info("Class ExpenditureController, method /add, testing");
        String content ="{\"companyName\":\"Test Name\", \"cost\":\"200\", \"frequency\":\"MONTH\", \"question\":\"ask test\"," +
                "\"user\":{\"id\" : \"1\"}}";
        ResultActions ra = this.mockMvc.perform(post("/expenditure/add").content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getExpenditure() throws Exception{
        log.info("Class Expenditurecontroller, method - /get, testing");
        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);

        List<Expenditure> expenditures = expenditureService.getExpenditureByParams(pb.getParams());

        if (expenditures.size() > 0){
            Expenditure expenditure = expenditures.get(0);
            log.info("Url /get, param id = " + expenditure.getId());
            String content = "{\"id\" : \"" + expenditure.getId() + "\"}";
            ResultActions ra = this.mockMvc.perform(get("/expenditure/get").content(content).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else
            log.info("User -" + username +  "  has no expenditure, to test the method - /expenditure/get");

    }

    @Test
    @Transactional
    @Rollback
    public void deleteExpenditure() throws Exception{
        log.info("Class Expenditurecontroller, method - /delete, testing");
        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);

        List<Expenditure> expenditures = expenditureService.getExpenditureByParams(pb.getParams());

        if (expenditures.size() > 0){
            Expenditure expenditure = expenditures.get(0);
            log.info("Url /delete, param id = " + expenditure.getId());
            String content = "{\"id\" : \"" + expenditure.getId() + "\"}";
            ResultActions ra = this.mockMvc.perform(post("/expenditure/delete").content(content).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else
            log.info("User -" + username +  "  has no expenditure, to test the method - /expenditure/delete");

    }


}
