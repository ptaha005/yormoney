package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.CalendarEvent;
import com.codexsoft.yormoney.services.CalendarService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/event", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CalendarEvent> calendarevent(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end, @RequestParam(value = "_" , required = false) String l) throws ParseException {
        Date startDate = new Date(Long.parseLong(start) * 1000);
        Date endDate = new Date(Long.parseLong(end) * 1000);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.greatThan("start", startDate);
        pb.lessThan("start", endDate);
        return calendarService.getListCalendarEventByParams(pb.getParams());
    }
}
