package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.Family;
import com.codexsoft.yormoney.domain.Member;
import com.codexsoft.yormoney.domain.Relationship;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.MemberService;
import com.codexsoft.yormoney.services.RoleService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.SimpleView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequestMapping(value = {"/member" , "/api/member"})
@Controller
public class MemberController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value="/relationships", method = RequestMethod.GET )
    public ModelAndView setRelationships(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        List<Member> members = memberService.getMemberCollectionByParams(pb.getParams());
        ModelAndView modelAV = new ModelAndView("relationships");
        modelAV.getModel().put("user", user);
        modelAV.getModel().put("members", members);
        return modelAV;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value="/add", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Member addMember(@RequestBody @Valid Member member, Principal principal, HttpSession session, BindingResult result){
        member.setUser(userService.findByUsername(principal.getName()));
        if (!result.hasErrors()) {
            Family family = (Family) session.getAttribute("family");
            if (family == null){
                family = new Family();
                family.setDescription(member.getLastName());
                session.setAttribute("family", family);
                memberService.saveOrUpdateFamily(family);
            }
            member.setFamily(family);

            memberService.saveOrUpdateMember(member);
            Hibernate.initialize(member);
            member.getJsonValues().put("success" , "true");
            return member;
        }
        member.getJsonValues().put("success", "false");
        member.getJsonValues().put("message", "Validation errors");
        ResultToJSON.trasition(member, result);
        return member;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value="/delete", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Member deleteMember(@RequestBody Map<String, Long> mapJSON){
        Long memberId = mapJSON.get("id");
        Member member = memberService.getMemberById(memberId);
        if (member == null){
            member = new Member();
            member.getJsonValues().put("succcess" , "false");
            member.getJsonValues().put("message" , "Not present in the database");
            return member;
        }
        memberService.deleteMember(member);
        member.getJsonValues().put("success", "true");
        return member;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value="/getMember", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Member getMember(@RequestBody Map<String, Long> mapJSON){
        Long memberId = mapJSON.get("id");
        Member member = memberService.getMemberById(memberId);
        if (member == null){
            member = new Member();
            member.getJsonValues().put("succcess" , "false");
            member.getJsonValues().put("message" , "Not present in the database");
            return member;
        }
        memberService.deleteMember(member);
        member.getJsonValues().put("success", "true");
        return member;
    }
    }
