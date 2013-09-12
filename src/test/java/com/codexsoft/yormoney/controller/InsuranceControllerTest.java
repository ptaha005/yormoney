package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.InsuranceService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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


import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class InsuranceControllerTest extends AbstractContextControllerTests {

    @Autowired
    UserService userService;
    @Autowired
    InsuranceService insuranceService;


    private final Logger log = Logger.getLogger(InsuranceControllerTest.class);

//    @Test
//    @Transactional
//    @Rollback
//    public void addInsurance() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/add POST , testing");
//        String content ="{\"frequency\":\"MONTH\", \"paymentDate\":\"200\", \"lifeAssuarence\":\"111\", \"purpose\":\"111\"," +
//               " \"cover\":\"111\",\"policyNumber\":\"123\",\"startDate\":\"2013-11-12\",\"endDate\":\"2013-12-1\",\"paymentAmount\":\"12.4\"}";
//        ResultActions ra = this.mockMvc.perform(post("/insurance/add").content(content).principal(auth).contentType(MediaType.APPLICATION_JSON));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void productInfo() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/productInfo GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/productInfo").principal(auth));
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        ra.andExpect(status().isOk());
//    }
//
//    @Test
//    public void init() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/init GET, testing");
//
//        ResultActions ra = this.mockMvc.perform(get("/insurance/init").principal(auth));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }

    @Test
    @Transactional
    @Rollback
    public void addNotes() throws Exception {
        log.info("Class InsuranceController, method - /insurance/notes POST, testing");
        String content ="[{\"description\":\"12sdfg\",\"date\":\"2013-08-04\"},{\"description\":\"dffgdf\",\"date\":\"2013-08-04\"}]";
        Insurance insurance = userService.findByUsername(username).getInsurance();
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("insurance",insurance);
        insurance.getNotes().clear();
        insuranceService.saveOrUpdateInsurance(insurance);
      //List<Note> notes = userService.getListNoteByParams(pb.getParams());
        ResultActions ra = this.mockMvc.perform(post("/insurance/notes").content(content).principal(auth)
        .contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
//
//    @Test
//    public void getNotes() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/notes GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/notes").principal(auth).contentType(MediaType.APPLICATION_JSON));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void getAddress() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/address GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/address").principal(auth));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//
//    }
//
//    @Test
//    @Transactional
//    public void getAddressById() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/address/{addressId} GET, testing");
//        User user = userService.findByUsername(username);
//        List<Address> addressList = user.getInsurance().getCompany().getAddresses();
//        if(addressList.size()>0){
//            Address address = addressList.get(0);
//            log.info("Url /get, param id = " + address.getId());
//            ResultActions ra = this.mockMvc.perform(get("/insurance/address/" + address.getId()).contentType(MediaType.APPLICATION_JSON).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no addresses, to test the method - /insurance/address/{addressId} GET, testing");
//        }
//
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void addAddress() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/address POST, testing");
//        String content ="{\"description\":\"notes\",\"name\":\"minsk\"}";
//        ResultActions ra = this.mockMvc.perform(post("/insurance/address").content(content).principal(auth)
//                .contentType(MediaType.APPLICATION_JSON));
//
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void updateAddress() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/address PUT, testing");
//        String content ="{\"description\":\"PopStyle\",\"name\":\"AkPtaha\"}";
//        ResultActions ra = this.mockMvc.perform(put("/insurance/address").content(content).principal(auth).contentType(MediaType.APPLICATION_JSON));
//
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void deleteAddress() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/address DELETE, testing");
//        User user = userService.findByUsername(username);
//        List<Address> addressList = user.getInsurance().getCompany().getAddresses();
//        if(addressList.size()>0){
//            Address address = addressList.get(0);
//            log.info("Url /get, param id = " + address.getId());
//            ResultActions ra = this.mockMvc.perform(delete("/insurance/address/" + address.getId()).contentType(MediaType.APPLICATION_JSON).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no addresses, to test the method - /insurance/address DELETE, testing");
//        }
//
//    }
//
//    @Test
//    public void getPhone() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/phone GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/phone").principal(auth));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void getPhoneById() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/phone/{phoneId} GET, testing");
//        User user = userService.findByUsername(username);
//        List<Phone> phoneList = user.getInsurance().getCompany().getPhones();
//        if(phoneList.size()>0){
//            Phone phone = phoneList.get(0);
//            log.info("Url /get, param id = " + phone.getId());
//            ResultActions ra = this.mockMvc.perform(get("/insurance/phone/" + phone.getId()).contentType(MediaType.APPLICATION_JSON).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no phones, to test the method - /insurance/phone/{phoneId} GET, testing");
//        }
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void addPhone() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/phone POST, testing");
//        String content ="{\"description\":\"notes\",\"name\":\"kolokolok\"}";
//        ResultActions ra = this.mockMvc.perform(post("/insurance/phone").content(content).principal(auth)
//                .contentType(MediaType.APPLICATION_JSON));
//
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void updatePhone() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/phone PUT, testing");
//        String content ="{\"description\":\"notes\",\"name\":\"kolokolok\"}";
//        ResultActions ra = this.mockMvc.perform(put("/insurance/phone").content(content).principal(auth)
//        .contentType(MediaType.APPLICATION_JSON));
//
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void deletePhone() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/phone DELETE, testing");
//        User user = userService.findByUsername(username);
//        List<Phone> phoneList = user.getInsurance().getCompany().getPhones();
//        if(phoneList.size()>0){
//            Phone phone = phoneList.get(0);
//            log.info("Url /get, param id = " + phone.getId());
//            ResultActions ra = this.mockMvc.perform(delete("/insurance/phone/" + phone.getId()).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no phones, to test the method - /insurance/phone/{phoneId} Delete, testing");
//        }
//
//    }
//
//    @Test
//    public void getEmail() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/email GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/email").principal(auth));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    @Transactional
//
//    public void getEmailById() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/email/{emailId} GET, testing");
//        User user = userService.findByUsername(username);
//        List<Email> emailList = user.getInsurance().getCompany().getEmails();
//        if(emailList.size()>0){
//            Email email = emailList.get(0);
//            log.info("Url /get, param id = " + email.getId());
//            ResultActions ra = this.mockMvc.perform(get("/insurance/email/" + email.getId()).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no emails, to test the method - /insurance/email/{emailId} GET, testing");
//        }
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//
//    public void addEmail() throws Exception {
//        log.info("Class InsuranceController, method - /insurance/email POST, testing");
//        String content ="{\"email\":\"alikapon4ik@revolivero.bym\",\"name\":\"Don Pomidor\"}";
//        ResultActions ra = this.mockMvc.perform(post("/insurance/email").content(content).principal(auth)
//        .contentType(MediaType.APPLICATION_JSON));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void updateEmail() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/email PUT, testing");
//        String content ="{\"email\":\"ShparKiPtah@shuga.pop\",\"name\":\"555\"}";
//        ResultActions ra = this.mockMvc.perform(put("/insurance/email").content(content).principal(auth)
//                .contentType(MediaType.APPLICATION_JSON));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void deleteEmail() throws Exception{
//        log.info("Class InsuranceController, method - /insurance/email DELETE, testing");
//        User user = userService.findByUsername(username);
//        List<Email> emailList = user.getInsurance().getCompany().getEmails();
//        if(emailList.size()>0){
//            Email email = emailList.get(0);
//            log.info("Url /get, param id = " + email.getId());
//            ResultActions ra = this.mockMvc.perform(delete("/insurance/email/" + email.getId()).principal(auth));
//            ra.andExpect(status().isOk());
//            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        } else{
//            log.info("User -"+ username + " has no emails, to test the method - /insurance/email/{emailId} DELETE, testing");
//        }
//    }
//
//    @Test
//    public void listPayment()throws Exception{
//        log.info("Class InsuranceController, method - /insurance//listPayment GET, testing");
//        ResultActions ra = this.mockMvc.perform(get("/insurance/listPayment").param("sEcho","1")
//                .param("sSearch","")
//                .param("iDisplayLength","-1")
//                .param("iDisplayStart","0")
//                .param("iColumns","2")
//                .param("iSortingCols","1")
//                .param("iSortCol_0","0")
//                .param("sSortDir_0","asc")
//                .param("sColumns","").principal(auth));
//        ra.andExpect(status().isOk());
//        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//
//    }
}
