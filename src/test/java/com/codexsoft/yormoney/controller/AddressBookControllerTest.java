package com.codexsoft.yormoney.controller;
//
import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Contact;
import com.codexsoft.yormoney.domain.Roles;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.security.SigninUtil;
import com.codexsoft.yormoney.services.ContactService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;




@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class AddressBookControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(AddressBookControllerTest.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @Test
    public void list() throws Exception{
        log.info("Class AddressBookController , method - /list/{firstletter}, testing");

        for (int i = 0; i < 26; i++){
            log.info("Url: /addressbook/list/" + (char)('a' + i));
            ResultActions resultActions =  this.mockMvc.perform(post("/addressbook/list/" + (char) ('a' + i)).
                    principal(auth));
            resultActions.andExpect(status().isOk());
            resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Test
    @Transactional
    @Rollback
    public void deleteContact() throws Exception{
        log.info("Class AddressBookController , method - /delete, testing");
        User user = userService.findByUsername(username);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        List<Contact> contacts =  contactService.getContactListByParams(pb.getParams());

        if (contacts.size() > 0) {
            Contact contact = contacts.get(0);
            log.info("Url /addressbook/delete, param: id = " + contact.getId());
            String content = "{\"id\" : \"" + contact.getId() + "\"}";
            ResultActions ra = this.mockMvc.perform(post("/addressbook/delete").
                    content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else
            log.info("User -" + username +  "  has no contact, to test the method - /addressbook/delete");
    }

    @Test
    @Transactional
    @Rollback
    public void addContact() throws Exception {
        log.info("Class AddressBookController, method - /add, testing");
        String content = "{\"name\" : \"Test Contact\", \"phone\" : \"9090090\", \"email\" : \"iqaren@mail.ru\"," +
                "\"address\" : \"Minsk\", \"webaddress\" : \"http://google.com\", \"dateOfBirth\" : \"2000-02-28\"," +
                "\"fotopath\" : \"path/file/1.jpg\", \"note\" : [{\"description\" : \"Test Note\"}]," +
                "\"user\":{\"id\" : \"1\"}}";
        ResultActions ra = this.mockMvc.perform(post("/addressbook/add").
                content(content.getBytes()).principal(auth).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
