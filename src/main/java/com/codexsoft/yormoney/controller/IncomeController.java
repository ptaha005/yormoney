package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.BankAccountService;
import com.codexsoft.yormoney.services.ExpenditureService;
import com.codexsoft.yormoney.services.IncomeService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.*;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.JsonView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = {"/income", "/api/income"})
@Controller
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService bankAccountService;

    public Map<String, Object> getIncomeParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb.getParams();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Income addIncome(@RequestBody Income income, Principal principal, Model model, BindingResult result){
        if (income.getIncomeType() != null && income.getIncomeType().getId() == null)
            income.setIncomeType(null);
        if (income.getMember() != null && income.getMember().getId() == null)
            income.setMember(null);
        if (income.getBankAccount() != null && income.getBankAccount().getId() == null)
            income.setBankAccount(null);
        if (result.hasErrors()){
            income.getJsonValues().put("succcess", "false");
            income.getJsonValues().put("message", "Validation errors");
            ResultToJSON.trasition(income, result);
            return income;
        }
        User user = userService.findByUsername(principal.getName());

        income.setUser(user);
        incomeService.saveOrUpdateIncome(income);
        income.getJsonValues().put("success" , "true");
        return income;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Income delete(@RequestBody Map<String, Long> mapJSON){
        Long incomeId = mapJSON.get("id");
        Income income = incomeService.getIncomeById(incomeId);
        if (income == null) {
            income = new Income();
            income.getJsonValues().put("success" , "false");
            income.getJsonValues().put("message" , "Not present in the database");
            return income;
        }
        incomeService.deleteIncome(income);
        income.getJsonValues().put("success" , "true");
        return income;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/getIncome", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Income getIncome(@RequestBody Map<String, Long> mapJSON){
        Long incomeId = mapJSON.get("id");
        Income income = incomeService.getIncomeById(incomeId);
        if (income == null) {
            income = new Income();
            income.getJsonValues().put("success" , "false");
            income.getJsonValues().put("message" , "Not present in the database");
            return income;
        }
        income.getJsonValues().put("success" , "true");
        return income;
    }

    @Transactional
    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/listIncome", method = RequestMethod.GET)
    public View listIncome(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Income> contacts = incomeService.getIncomeByParams(param, getIncomeParam(principal));
        model.addAttribute("data", contacts);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value ="/getIncomeType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IncomeType> getIncomeType(){
        return incomeService.getIncomeTypes();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> init(Principal principal){
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.findByUsername(principal.getName());
        map.put("members", user.getMembers());
        map.put("frequency", Frequency.values());
        map.put("day", Day.values());
        map.put("incometypes", incomeService.getIncomeTypes());
        map.put("bankaccount", bankAccountService.getListBankAccountByParams(ParamBuilder.getBuilder().equal("user", user).getParams()));
        return map;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/addIncomeType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncomeType addIncomeType(@RequestBody Map<String, String> mapJSON, Principal principal){
        User user = userService.findByUsername(principal.getName());
        Long incomeCategoryId = Long.parseLong(mapJSON.get("id"));
        String name = mapJSON.get("name");
        IncomeCategory incomeCategory = incomeService.getIncomeCategoryById(incomeCategoryId);
        IncomeType incomeType = new IncomeType();
        incomeType.setUser(user);
        incomeType.setIncomeCategory(incomeCategory);
        incomeType.setName(name);

        incomeType.getJsonValues().put("success", true);

        return incomeType;
    }


    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IncomeCategory> category(){
        return incomeService.getIncomeCategory();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/incomeType/{incomeCategoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IncomeType> incomeType(@PathVariable Long incomeCategoryId, Principal principal){
        User user = userService.findByUsername(principal.getName());
        IncomeCategory  incomeCategory = incomeService.getIncomeCategoryById(incomeCategoryId);
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("category", incomeCategory);
        pb.isNull("user");
        List<IncomeType> incomeTypes = incomeService.getIncomeTypesByParams(pb.getParams());

        pb = ParamBuilder.getBuilder();
        pb.equal("category", incomeCategory);
        pb.equal("user", user);
        incomeTypes.addAll(incomeService.getIncomeTypesByParams(pb.getParams()));

        if (incomeTypes == null)
            incomeTypes = new ArrayList<IncomeType>();

        return incomeTypes;
    }
}
