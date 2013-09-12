package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.jsonserializers.JsonSerializer;
import com.codexsoft.yormoney.services.ContactService;
import com.codexsoft.yormoney.services.MemberService;
import com.codexsoft.yormoney.services.TaskService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.JsonView;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Date;

@RequestMapping(value = {"/task", "/api/task"})
@Controller
public class TaskController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private MemberService memberService;

    public ParamBuilder getPrincipalParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb;
    }


    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Task add(@RequestBody @Valid Task task, Principal principal, BindingResult result){
        task.setUser(userService.findByUsername(principal.getName()));
        if (task.getComplete() == null)
            task.setComplete(0);

        if (result.hasErrors()){
            task.getJsonValues().put("success" , "false");
            task.getJsonValues().put("message", "Validation erros");
            return task;
        }
        taskService.saveOrUpdateTask(task);
        task.getJsonValues().put("success", "true");
        return task;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Task delete(@RequestBody Map<String, Long> mapJSON){
        Long id = mapJSON.get("id");
        Task task = taskService.getTaskById(id);
        if (task == null){
            task = new Task();
            task.getJsonValues().put("success", "false");
            task.getJsonValues().put("message", "Not present in the database");
            return task;
        }
        taskService.deleteTask(task);
        task.getJsonValues().put("message", "true");
        return task;
    }

    @Transactional
    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/listTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  DatatablesStructure<Task> listTask(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Task> tasks = taskService.getTaskByParams(param, getPrincipalParam(principal).getParams());
        return tasks;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Task init(Principal principal){
        Task task = new Task();
        task.setStartDate(new Date());
        task.setDueDate(new Date());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", userService.findByUsername(principal.getName()));
        task.getJsonValues().put("complete", Percent.a);
        task.getJsonValues().put("members", memberService.getMemberCollectionByParams(pb.getParams()));
        task.getJsonValues().put("reminder", Reminder.a);
        return task;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Task init(@PathVariable() Long id, Principal principal){
        Task task = taskService.getTaskById(id);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", userService.findByUsername(principal.getName()));
        task.getJsonValues().put("complete" , Percent.a);
        task.getJsonValues().put("reminder", Reminder.a);
        task.getJsonValues().put("members", memberService.getMemberCollectionByParams(pb.getParams()));
        return task;
    }
}
