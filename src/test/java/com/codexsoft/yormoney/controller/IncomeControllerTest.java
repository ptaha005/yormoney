package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Expenditure;
import com.codexsoft.yormoney.domain.Income;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.ExpenditureService;
import com.codexsoft.yormoney.services.IncomeService;
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
public class IncomeControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(ExpenditureControllerTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeService incomeService;

    @Test
    public void getIncomeTypes() throws Exception{
        log.info("Class IncomeController, method - /getIncomeType, testing");
        ResultActions ra = this.mockMvc.perform(get("/income/getIncomeType"));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void addIncome() throws Exception{
        log.info("Class IncomeController, method /add, testing");
        String content ="{\"incomeSource\":\"Test Name\", \"amount\":\"200\", \"frequency\":\"MONTH\", \"question\":\"ask test\"," +
                "\"user\":{\"id\" : \"1\"}}";
        ResultActions ra = this.mockMvc.perform(post("/income/add").content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getIncome() throws Exception{
        log.info("Class IncomeController, method - /getIncome, testing");
        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);

        List<Income> incomes = incomeService.getIncomesByParams(pb.getParams());

        if (incomes.size() > 0){
            Income income = incomes.get(0);
            log.info("Url /getIncome, param id = " + income.getId());
            String content = "{\"id\" : \"" + income.getId() + "\"}";
            ResultActions ra = this.mockMvc.perform(get("/income/getIncome").content(content).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else
            log.info("User -" + username +  "  has no income, to test the method - /income/getIncome");
    }

    @Test
    @Transactional
    @Rollback
    public void deleteIncome() throws Exception{
        log.info("Class IncomeController, method - /delete, testing");
        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);

        List<Income> incomes = incomeService.getIncomesByParams(pb.getParams());

        if (incomes.size() > 0){
           Income income = incomes.get(0);
            log.info("Url /delete, param id = " + income.getId());
            String content = "{\"id\" : \"" + income.getId() + "\"}";
            ResultActions ra = this.mockMvc.perform(post("/income/delete").content(content).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else
            log.info("User -" + username +  "  has no income, to test the method - /income/delete");

    }

}
