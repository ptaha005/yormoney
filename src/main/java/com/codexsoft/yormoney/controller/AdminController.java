package com.codexsoft.yormoney.controller;


import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = {"/admin" , "/api/admin"})
@Controller
public class AdminController {

    private UserService userService;


    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){

        User userByUsername = userService.findByUsername(user.getUsername());
        User userByEmail = userService.findByEmail(user.getEmail());

        if (userByEmail != null){
            user.getJsonValues().put("status", "false");
            user.getJsonValues().put("message", "User with this email exists");
            return user;
        }

        if (userByUsername != null){
            user.getJsonValues().put("status", "false");
            user.getJsonValues().put("message", "User with that username exists");
            return user;
        }

        userService.saveOrUpdateUser(user);

        user.getJsonValues().put("status", "true");
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user){

        if (userService.getUserById(user.getId()) != null){
            userService.merge(user);
            user.getJsonValues().put("status", "true");
            return user;
        } else {
            user.getJsonValues().put("status", "false");
            user.getJsonValues().put("message", "User not found");
            return user;
        }

//        userService.saveOrUpdateUser(user);
//        return user;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUser(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        try {
            userService.deleteUser(user);
            user.getJsonValues().put("status", "true");
        } catch (Exception e){
            user.getJsonValues().put("status" , "false");
            user.getJsonValues().put("message", "Error");
        }

        return user;
    }

    @RequestMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
}
