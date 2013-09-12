package com.codexsoft.yormoney;

import com.codexsoft.yormoney.domain.Roles;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration("classpath:spring-application-context.xml")
@ActiveProfiles("test")
public class AbstractContextControllerTests {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    protected Authentication auth;

    protected String username = "yormoney";

    protected String password = "yormoney";

    @Before
    public void setup(){
        SecurityContextHolder.clearContext();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        auth =  new UsernamePasswordAuthenticationToken(username, password,  AuthorityUtils.createAuthorityList(Roles.Regular.getName()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
