package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.User;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class RegistrationControllerTest extends AbstractContextControllerTests {

   @Autowired
    UserService userService;

    private final Logger log = Logger.getLogger(RegistrationControllerTest.class);

   @Test
   @Transactional
   @Rollback
   public void sendAC()throws Exception{
       log.info("Class RegistrationController, method - /registration/sendActivationCode, testing");
       String content = "{\"firstName\":\"Andriano\",\"lastName\":\"Chelentano\",\"email\":\"ptaha005@gmail.com\",\"occupation\":\"none\",\"username\":\"andrey\",\"password\":\"andrey\",\"address\":\"Backer St.\",\"postcode\":\"12344321\",\"timezone\":-180,\"dateOfBirthday\":\"1999-12-12\"}";
       ResultActions ra = this.mockMvc.perform(post("/registration/sendActivationCode").content(content).principal(auth)
       .contentType(MediaType.APPLICATION_JSON));
       ra.andExpect(status().isOk());
       ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));

   }

    @Test
    @Transactional
    @Rollback
    public void activate()throws Exception{

        log.info("Class RegistrationController, method - /registration/activate, testing");

        User user = userService.findByUsername(username);
        String content = "{\"activationCode\":\""+user.getActivationCode()+"\"}";

        ResultActions ra1 = this.mockMvc.perform(post("/registration/activate").content(content).principal(auth)
                .contentType(MediaType.APPLICATION_JSON));
        ra1.andExpect(status().isOk());
        ra1.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
