package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.domain.Video;
import com.codexsoft.yormoney.services.PageService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequestMapping(value = {"/page" , "/api/page"})
@Controller
public class PageController {

    @Autowired
    private PageService pageService;

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/manual/{value}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Manual> manual(@PathVariable String value){
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("type", value);
        List<Manual> manuals = pageService.getPageByParams(pb.getParams()).getManuals();
        Hibernate.initialize(manuals);
        if (manuals == null)
            manuals = new ArrayList<Manual>();
        return  manuals;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/video/{value}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Video> video(@PathVariable String value){
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("type", value);
        List<Video> videos =  pageService.getPageByParams(pb.getParams()).getVideos();
        Hibernate.initialize(videos);
        if (videos == null)
            videos = new ArrayList<Video>();
        return  videos;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/banner/{value}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String banner(@PathVariable String value){
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("type", value);
        List<Banner> banners =  pageService.getPageByParams(pb.getParams()).getBanners();

        Iterator<Banner> iter = banners.iterator();

        String result = "{";

        while (iter.hasNext()){
            Banner banner = iter.next();
            if (result.length() > 2)
                result += ",";
            result +=  "\""+ banner.getPosition()+"\" : {"+
            "    \"img\" : \"" + banner.getPath() + "\","+
            "    \"url\" : \"" + banner.getUrl() + "\""+
            "}";
        }

        result += "}";

        return  result;
    }
}
