package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.Event;
import com.codexsoft.yormoney.domain.EventExpenditureType;
import com.codexsoft.yormoney.domain.EventType;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.EventService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import com.codexsoft.yormoney.views.JsonView;
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
import java.security.Principal;
import java.util.*;

/**
 * User: mikhail@codex-soft.com
 * Date: 7/9/13
 */
@RequestMapping(value = {"/event", "/api/event"})
@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/plainlist/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> getEvents(@PathVariable long type,  Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Map<String, Object> map  = new HashMap<String, Object>();
        map.put("type", type);
        map.put("events", eventService.getListEvents(user.getId(), type));
        List<String> path = new ArrayList<String>();
            while (type != 0) {
            EventExpenditureType eventExpenditureType = eventService.getEventExpenditureTypeById(type);
            if (eventExpenditureType == null){
                map = new HashMap<String, Object>();
                map.put("success" , "false");
                return map;
            }
            path.add(eventExpenditureType.getName());
            type = eventExpenditureType.getParentType().getId();
        }
        Collections.reverse(path);
        map.put("path", path);
        map.put("expenditureType", eventService.getListEvents(user.getId(), 0));

        return  map;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  DatatablesStructure<Event> listIncome(Model model, @PathVariable long type, HttpServletRequest request,  Principal principal) {
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        User user = userService.findByUsername(principal.getName());
        DatatablesStructure<Event> events = eventService.getEventByParams(user.getId(), type, param);
        return events;
    }
    //date - YYYY - MM - DD
     //{"id":1,"active":true,"agreedSpend":100, "date" : "2002-02-02","eventExpenditureType":{"id":1}}
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Event add(@RequestBody Event event, Principal principal, Model model, BindingResult result) {
        if (result.hasErrors()) {
            event.getJsonValues().put("success", "false");
            event.getJsonValues().put("message", "Validation errors");
            ResultToJSON.trasition(event, result);
            return event;
        }

        User user = userService.findByUsername(principal.getName());
        event.setUser(user);
        eventService.saveOrUpdateEvent(event);
        event.getJsonValues().put("success", "true");
        return event;
    }

}
