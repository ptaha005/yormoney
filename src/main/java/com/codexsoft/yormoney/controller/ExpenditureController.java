package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.BankAccountService;
import com.codexsoft.yormoney.services.ExpenditureService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.CategoryTotal;
import com.codexsoft.yormoney.util.ExpenditureTotal;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.*;
import com.codexsoft.yormoney.views.JsonView;
import com.codexsoft.yormoney.views.SimpleView;
import org.hibernate.Hibernate;
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

@RequestMapping(value = {"/expenditure" , "/api/expenditure"})
@Controller
public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService bankAccountService;


    public Map<String, Object> getExpenditureParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb.getParams();
    }

    public ParamBuilder getPrincipalParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/expendituretypes" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ExpenditureType> getExpenditureType(){
        return expenditureService.getExpenditureTypes();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Category> getCategories(){
        return expenditureService.getCategories();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Expenditure add(@RequestBody Expenditure expenditure, Principal principal, Model model, BindingResult result){

        if (expenditure.getExpenditureType() != null && expenditure.getExpenditureType().getId() == null)
            expenditure.setExpenditureType(null);
        if (expenditure.getMember() != null && expenditure.getMember().getId() == null)
            expenditure.setMember(null);
        if (expenditure.getBankAccount() != null && expenditure.getBankAccount().getId() == null)
            expenditure.setBankAccount(null);
        if (result.hasErrors()){
            expenditure.getJsonValues().put("succcess", "false");
            ResultToJSON.trasition(expenditure, result);
            return expenditure;
        }

        User user = userService.findByUsername(principal.getName());
        expenditure.setUser(user);
        expenditureService.saveOrUpdateExpenditure(expenditure);
        expenditure.getJsonValues().put("success" , "true");
        return expenditure;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/get", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Expenditure getExpenditure(@RequestBody Map<String, Long> mapJSON){
        Long expenditureId = mapJSON.get("id");
        Expenditure expenditure = expenditureService.getExpenditureById(expenditureId);
        if (expenditure == null) {
            expenditure = new Expenditure();
            expenditure.getJsonValues().put("success" , "false");
            expenditure.getJsonValues().put("message" , "Not present in the database");
            return expenditure;
        }
        expenditure.getJsonValues().put("success" , "true");
        return expenditure;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Expenditure delete(@RequestBody Map<String, Long> mapJSON){
        Long expenditureId = mapJSON.get("id");
        Expenditure expenditure = expenditureService.getExpenditureById(expenditureId);
        if (expenditure == null) {
            expenditure = new Expenditure();
            expenditure.getJsonValues().put("success" , "false");
            expenditure.getJsonValues().put("message" , "Not present in the database");
            return expenditure;
        }
        expenditureService.deleteExpenditure(expenditure);
        expenditure.getJsonValues().put("success" , "true");
        return expenditure;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public View listExpenditure(Model model, Principal principal, HttpServletRequest request){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Expenditure> contacts = expenditureService.getExpenditureByParams(param, getExpenditureParam(principal));
        model.addAttribute("data", contacts);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/frequency/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Frequency[] getFrequency(){
        return Frequency.values();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/day/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Day[] getDays(){
        return Day.values();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/total", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CategoryTotal> getamount(Principal principal){
        List<Expenditure> expenditures = expenditureService.getExpenditureByParams(getExpenditureParam(principal));
        List<CategoryTotal> listCT = new ArrayList<CategoryTotal>();
        Iterator<Expenditure> iter = expenditures.iterator();
        int q = 0;
        while(iter.hasNext()){
            Expenditure expenditure = iter.next();
            if(expenditure.getExpenditureType() == null){
                continue;
            }
            String nameExpenditure = expenditure.getExpenditureType().getName();
            String nameCategory = expenditure.getExpenditureType().getCategory().getName();
            Iterator<CategoryTotal> iterCT = listCT.iterator();
            CategoryTotal ct = null;
            q = 0;
            while(iterCT.hasNext()){
                ct = iterCT.next();
                if (ct.getName().equalsIgnoreCase(nameCategory)){
                    q = 1;
                    iterCT.remove();
                    break;
                }
            }
            if (q == 0)
                ct = new CategoryTotal();

            List<ExpenditureTotal> listET = ct.getItems();
            Iterator<ExpenditureTotal> iterET = listET.iterator();
            ExpenditureTotal et = null;
            q = 0;
            while(iterET.hasNext()){
                et = iterET.next();
                if (et.getName().equalsIgnoreCase(nameExpenditure)){
                    q  = 1;
                    iterET.remove();
                    break;
                }
            }
            if (q == 0) {
                et = new ExpenditureTotal();
            }
            et.setName(nameExpenditure);
            et.setPrice((et.getPrice() != null ? et.getPrice() : 0) + ( expenditure.getCost() != null ? expenditure.getCost() : 0));
            ct.addItems(et);
            ct.setName(nameCategory);
            ct.setPrice((ct.getPrice() != null ? ct.getPrice() : 0) + ( expenditure.getCost() != null ? expenditure.getCost() : 0));
            listCT.add(ct);
        }
        return listCT;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> init(Principal principal){
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.findByUsername(principal.getName());
        map.put("members", user.getMembers());
        map.put("frequency", Frequency.values());
        map.put("day", Day.values());
     //  map.put("expendituretypes", expenditureService.getExpenditureTypes());
        map.put("categories", expenditureService.getCategories());
        map.put("bankaccount", bankAccountService.getListBankAccountByParams(ParamBuilder.getBuilder().equal("user", user).getParams()));
        return map;
    }
}
