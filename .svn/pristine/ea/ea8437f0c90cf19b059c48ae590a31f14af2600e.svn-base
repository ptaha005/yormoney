package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.*;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;


@Controller
@RequestMapping(value = {"/dashboard", "/api/dashboard"})
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private InsuranceService insuranceService;

    public ParamBuilder getPrincipalParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb;
    }

    private List getPeriodParam(Period period, Principal principal , String type){
        User user = userService.findByUsername(principal.getName());
        Calendar startCalendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(user.getTimezone()));
        Calendar endCalendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(user.getTimezone()));
        startCalendar.setTimeZone(TimeZone.getDefault());
        endCalendar.setTimeZone(TimeZone.getDefault());
        endCalendar.add(Calendar.DATE, 1);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        Date start = startCalendar.getTime();
        Date end = startCalendar.getTime();
        switch(period){
            case day:
                break;
            case weekly:
                startCalendar.add(Calendar.DATE,  -startCalendar.get(Calendar.DAY_OF_WEEK) + 1);
                endCalendar.add(Calendar.DATE, endCalendar.get(Calendar.DATE) -1);
                break;
            case weekly2:
                startCalendar.add(Calendar.DATE,  -startCalendar.get(Calendar.DAY_OF_WEEK) + 1);
                endCalendar.add(Calendar.DATE, 14 - endCalendar.get(Calendar.DAY_OF_WEEK));
                break;
            case monthly:
                startCalendar.add(Calendar.DATE,  -startCalendar.get(Calendar.DAY_OF_MONTH) + 1);
                endCalendar.add(Calendar.DATE, -endCalendar.get(Calendar.DAY_OF_MONTH) + 1);
                endCalendar.add(Calendar.MONTH, 1);
                break;
        }
        endCalendar.add(Calendar.SECOND, -1);

        start = startCalendar.getTime();
        end = endCalendar.getTime();

        ParamBuilder pb = getPrincipalParam(principal);
        if ("task".equals(type)) {
            return taskService.getTasksByDate(start , end, user.getId());
        } else if("transaction".equals(type)) {
            pb.greatThan("date" , start);
            pb.lessThan("date", end);
            return insuranceService.getPaymentListByParams(pb.getParams());
        } else{
           return calendarService.getCalendarEventsByDate(start, end, user.getId());
        }
    }


    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/task" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesStructure<Task> task(@RequestParam(value = "period") Period period, Model model, HttpServletRequest request){
        List<Task> list =(List<Task>) getPeriodParam(period, request.getUserPrincipal(), "task");
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Task> tasks = taskService.getTaskByParams(param, null);
        tasks.setData(list);
        return tasks;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/event", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesStructure<CalendarEvent> event(@RequestParam(value = "period") Period period, Model model, HttpServletRequest request){
        List<CalendarEvent> list = getPeriodParam(period, request.getUserPrincipal(), "event");
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<CalendarEvent> calendarEvents = calendarService.getCalendarEventByParams(param, null);
        calendarEvents.setData(list);
        return calendarEvents;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/transaction" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesStructure<Transaction> transaction(@RequestParam(value = "period") Period period, Model model, HttpServletRequest request){
        List<Transaction> list = getPeriodParam(period, request.getUserPrincipal(), "transaction");
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Transaction> transactions =insuranceService.getPaymentByParams(param, null);
        transactions.setData(list);
        return transactions;
    }

}
