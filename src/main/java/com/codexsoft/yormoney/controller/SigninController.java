package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class SigninController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/signin", "/"})
    public ModelAndView signin(Model model){
        ModelAndView mav = new ModelAndView("index");
        mav.getModel().put("env", System.getProperty("yormoney.environment"));
        return mav;
    }

//    @RequestMapping(value = "/forgotpassword/{token}", method = RequestMethod.GET)
//    public String forpass(@PathVariable String token){
//        ParamBuilder pb = ParamBuilder.getBuilder();
//        pb.equal("token", token);
//        User user = userService.getUserByParams(pb.getParams());
//        String newPassword = UUID.randomUUID().toString().substring(0, 8);
//        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//        user.setPassword(md5.encodePassword(newPassword, null));
//        userService.saveOrUpdateUser(user);
//
//        return "redirect: /signin";
//    }
}
