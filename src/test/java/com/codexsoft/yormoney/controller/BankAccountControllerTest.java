package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.BankAccount;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.BankAccountService;
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
public class BankAccountControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(BankAccountControllerTest.class);

    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    UserService userService;

    @Test
    @Transactional
    @Rollback
    public void addBankAccount() throws Exception{
        log.info("Class BankAccountController, method - /add, testing");
        String content = "{\"purpose\" : \"Test BankAccount\", \"balance\" : \"9090\", \"user\":{\"id\" : \"1\"}}";
        ResultActions ra = this.mockMvc.perform(post("/bankaccount/add").
                content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void bankAccount() throws Exception {
        log.info("Class BankAccountController, method - /bankaccount, testing");

        ResultActions ra  = this.mockMvc.perform(post("/bankaccount/bankaccount").content("{\"id\" : \"1\"}").principal(auth)
        .contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @Transactional
    @Rollback
    public void deleteBankAccount() throws Exception {
        log.info("Class BankAccountController, method - /delete, testing");

        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user",user);

        List<BankAccount> bankAccounts = bankAccountService.getListBankAccountByParams(pb.getParams());
        if(bankAccounts.size()>0){
            BankAccount bankAccount = bankAccounts.get(0);
            log.info("Url /bankaccount/delete, param: id = " + bankAccount.getId());


            ResultActions ra  = this.mockMvc.perform(post("/bankaccount/delete").content("{\"id\" : \""+bankAccount.getId()+"\"}").principal(auth)
                .contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));

        } else {
            log.info(" User -" + username +  "  has no bankaccount, to test the method - /bankaccount/delete");
        }
    }

    @Test
    public void list() throws Exception {
        log.info("Class BankAccountController, method - /list, testing");
        ResultActions ra = this.mockMvc.perform(get("/bankaccount/list").param("sEcho","1")
                .param("sSearch","")
                .param("iDisplayLength","10")
                .param("iDisplayStart","0")
                .param("iColumns","7")
                .param("iSortingCols","1")
                .param("iSortCol_0","0")
                .param("sSortDir_0","asc")
                .param("sColumns","").principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getBankList() throws Exception{
        log.info("Class BankAccountController, method - /banks/list, testing");
        ResultActions ra = this.mockMvc.perform(get("/bankaccount/banks/list").principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getBankAccountList()throws Exception{
        log.info("Class BankAccountController, method - /bankaccounts/list, testing");
        ResultActions ra = this.mockMvc.perform(get("/bankaccount/bankaccounts/list").principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void getbankAccountType()throws Exception{
        log.info("Class BankAccountController, method - /accounttypes/list, testing");
        ResultActions ra = this.mockMvc.perform(get("/bankaccount/accounttypes/list").principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void init()throws Exception{
        log.info("Class BankAccountController, method - /init, testing");
        ResultActions ra = this.mockMvc.perform(get("/bankaccount/init").principal(auth));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


}