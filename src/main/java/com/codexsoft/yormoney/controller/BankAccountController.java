package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.BankAccountService;
import com.codexsoft.yormoney.services.MemberService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.*;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.JsonView;
import com.codexsoft.yormoney.views.SimpleView;
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

@RequestMapping(value = {"/bankaccount", "/api/bankaccount"})
@Controller
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    public Map<String, Object> getBankAccountParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
       // pb.in("member", user.getMembers());
        return pb.getParams();
    }
    //JSON {"id":"value", "purpose" : "value", "balance" : "value", "accountType":{"field" : "value"}, "bank" :{..},"member" : {..}}
    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody BankAccount add(@RequestBody BankAccount bankAccount, Principal principal, Model model, BindingResult result){

        if (result.hasErrors()){
            bankAccount.getJsonValues().put("success" , "false");
            bankAccount.getJsonValues().put("message", "Validation errors");
            ResultToJSON.trasition(bankAccount, result);
            return bankAccount;
        }

        User user = userService.findByUsername(principal.getName());
        bankAccount.setUser(user);
        if (bankAccount.getId() == null)
            bankAccountService.saveOrUpdateBankAccount(setNullToEmptyFields(bankAccount));
        else
            bankAccountService.mergeBankAccount(bankAccount);
        bankAccount.getJsonValues().put("success", "true");
        return bankAccount;
    }

    private BankAccount setNullToEmptyFields(BankAccount bankAccount) {
        if (bankAccount.getBank() != null && bankAccount.getBank().getId() == null) {
            bankAccount.setBank(null);
        }
        if (bankAccount.getMember() != null && bankAccount.getMember().getId() == null) {
            bankAccount.setMember(null);
        }
        if (bankAccount.getAccountType() != null && bankAccount.getAccountType().getId() == null) {
            bankAccount.setAccountType(null);
        }
        return bankAccount;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/bankaccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody BankAccount getBankAccount(@RequestBody Map<String, Long> mapJSON){
        Long bankAccountId = mapJSON.get("id");
        BankAccount bankAccount = bankAccountService.getBankAccountById(bankAccountId);
        if (bankAccount == null){
            bankAccount = new BankAccount();
            bankAccount.getJsonValues().put("success" , false);
            bankAccount.getJsonValues().put("message","Not present in the database");
            return bankAccount;
        }
        bankAccount.getJsonValues().put("success" , "true");
        return bankAccount;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody BankAccount delete(@RequestBody Map<String, Long> mapJSON){
        Long bankAccountId = mapJSON.get("id");
        BankAccount bankAccount = bankAccountService.getBankAccountById(bankAccountId);
        if (bankAccount == null){
            bankAccount = new BankAccount();
            bankAccount.getJsonValues().put("success" , false);
            bankAccount.getJsonValues().put("message","Not present in the database");
            return bankAccount;
        }
        bankAccountService.deleteBankAccount(bankAccount);
        bankAccount.getJsonValues().put("success" , "true");
        return bankAccount;
    }


    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/list", method = RequestMethod.GET )
    public View listBankAccount(Model model, Principal principal, HttpServletRequest request){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<BankAccount> contacts = bankAccountService.getBankAccountByParams(param, getBankAccountParam(principal));
        model.addAttribute("data", contacts);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/banks/list" , method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Bank> getBanks(){
          return bankAccountService.getBankList();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/bankaccounts/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<BankAccount> getBankAccounts(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return bankAccountService.getListBankAccountByParams(ParamBuilder.getBuilder().equal("user", user).getParams());
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/accounttypes/list" , method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AccountType> getBankAccountType(){
          return bankAccountService.getAccountTypeList();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> init(Principal principal){
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        pb.equal("accountHolder", true);
        List<Member> members = memberService.getMemberCollectionByParams(pb.getParams());
        if (members == null)
            members = new ArrayList<Member>();
        map.put("user.members", members);
        map.put("accounttypes", bankAccountService.getAccountTypeList());
        map.put("banks", bankAccountService.getBankList());
        return map;
    }


}
