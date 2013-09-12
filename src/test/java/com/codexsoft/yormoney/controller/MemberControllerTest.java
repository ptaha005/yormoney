package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Member;
import com.codexsoft.yormoney.services.MemberService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@ActiveProfiles("dev")
public class MemberControllerTest extends AbstractContextControllerTests {
    @Autowired
    UserService userService;

    @Autowired
    MemberService memberService;

    private final Logger log = Logger.getLogger(MemberControllerTest.class);

    @Test
    public void relationships()throws Exception{
        log.info("Class MemberController, method -/relationships ,testing");
        ResultActions ra = this.mockMvc.perform(get("/member/relationships").principal(auth));
        ra.andExpect(view().name("relationships"));
    }

    @Test
    @Transactional
    @Rollback
    public void add() throws Exception {
        log.info("Class MemberController, method -/add ,testing");
        String json="{\"id\":\"\",\"firstName\":\"bob\",\"lastName\":\"bobik\",\"email\":\"yormoney@yor.com\",\"occupation\":\"111\",\"relationship\":{\"id\":1,\"name\":\"Son\"},\"accountHolder\":true,\"dateOfBirth\":\"10/9/2013\"}";
        ResultActions ra =this.mockMvc.perform(post("/member/add").content(json).contentType(MediaType.APPLICATION_JSON).principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void delete() throws Exception {
        log.info("Class MemberController, method -/delete ,testing");
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user",userService.findByUsername(username));
        List<Member> members= memberService.getMemberCollectionByParams(pb.getParams());

        if(members.size()>0){
            Member member = members.get(0);
            String json = "{\"id\":\""+member.getId()+"\"}";
            ResultActions ra = this.mockMvc.perform(post("/member/delete").content(json)
                    .contentType(MediaType.APPLICATION_JSON).principal(auth));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }else{
            log.info("User -" + username +  "  has no member, to test the method - /member/delete");
        }

    }

    @Test
    @Transactional
    @Rollback
    public void getMenber() throws Exception {
        log.info("Class MemberController, method -/getMember ,testing");
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user",userService.findByUsername(username));
        List<Member> members= memberService.getMemberCollectionByParams(pb.getParams());

        if(members.size()>0){
            Member member = members.get(0);
            String json = "{\"id\":\""+member.getId()+"\"}";
            ResultActions ra = this.mockMvc.perform(post("/member/getMember").content(json)
                    .contentType(MediaType.APPLICATION_JSON).principal(auth));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }else{
            log.info("User -" + username +  "  has no member, to test the method - /member/getMember");
        }

    }


}
