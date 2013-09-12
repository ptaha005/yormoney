package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.*;
import com.codexsoft.yormoney.services.BankAccountService;
import com.codexsoft.yormoney.services.InsuranceService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.FileFilterImpl;
import com.codexsoft.yormoney.util.ResultToJSON;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import com.codexsoft.yormoney.views.JsonView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.io.File;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping(value = {"/api/insurance", "/insurance"})
public class     InsuranceController {

    @Autowired
    private UserService userService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private BankAccountService bankAccountService;

    @Value("#{wiringProperties['file.onDiskPath']}")
    private String onDiskPath;

    public ParamBuilder getPrincipalParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Insurance add(@RequestBody @Valid Insurance insurance, Principal principal, BindingResult result){
        insurance.setUser(userService.findByUsername(principal.getName()));
        if ((insurance.getCompany() != null && insurance.getCompany().getId() == null))
            insurance.setCompany(null);
        if ((insurance.getInsuranceCompany() != null && insurance.getInsuranceCompany().getId() == null))
            insurance.setInsuranceCompany(null);
        if ((insurance.getBankAccount() != null && insurance.getBankAccount().getId() == null))
            insurance.setBankAccount(null);
        if (result.hasErrors()) {
            insurance.getJsonValues().put("success", "false");
            insurance.getJsonValues().put("message", "Validation errors");
            ResultToJSON.trasition(insurance, result);
            return insurance;
        }
        insuranceService.saveOrUpdateInsurance(insurance);
        insurance.getJsonValues().put("success" , "true");
        return insurance;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/productInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String,Object> insurance(Principal principal){
        Map<String, Object> map = new HashMap<String, Object>();
        Insurance insurance = insuranceService.getInsuranceByParams(getPrincipalParam(principal).getParams());
        if (insurance == null)
            insurance = new Insurance();
        insuranceService.saveOrUpdateInsurance(insurance);
        if (insurance.getCompany() == null){
            Company company = new Company();
            company.setInsurance(insurance);
            insuranceService.saveOrUpdateCompany(company);
            insurance.setCompany(company);
        }
        insurance.setUser(userService.findByUsername(principal.getName()));
        List<InsuranceCompany> insuranceCompanies = insuranceService.getListInsuranceCompanies();
        Company company = insurance.getCompany();
        insuranceService.saveOrUpdateInsurance(insurance);
        Hibernate.initialize(insurance);
        map.put("insurance", insurance);
        map.put("compareSave", insuranceCompanies);
        map.put("addresses", company.getAddresses());
        map.put("phones", company.getPhones());

        ParamBuilder pb = getPrincipalParam(principal);
        pb.notEqual("name", "");
        List<Folder> folders = userService.getListFolderByParams(pb.getParams());
        if (folders == null)
            folders = new ArrayList<Folder>();
        
       // List<String> nameFolders = new ArrayList<String>();
        // Iterator<Folder> iter = folders.iterator();

        // while(iter.hasNext()) {
        //     String name = iter.next().getName();
        //     if (!"".equals(name))
        //         nameFolders.add(name);
        // }
        map.put("folders", folders);
        
        return map;
    }


    @Transactional
    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/listPayment", method = RequestMethod.GET)
    public View listInsurance(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        ParamBuilder pb = getPrincipalParam(principal);
        pb.equal("type", TransactionType.Insurance.getName());
        DatatablesStructure<Transaction> transactions = insuranceService.getPaymentByParams(param, pb.getParams());
        model.addAttribute("data",transactions);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> init(Principal principal){
        Map<String, Object> map = new HashMap<String, Object>();
        Insurance insurance = insuranceService.getInsuranceByParams(getPrincipalParam(principal).getParams());
        List<InsuranceCompany> insuranceCompanies = insuranceService.getListInsuranceCompanies();
        if (insurance == null)
            insurance = new Insurance();
        insuranceService.saveOrUpdateInsurance(insurance);
        if (insurance.getCompany() == null){
            Company company = new Company();
            company.setInsurance(insurance);
            insuranceService.saveOrUpdateCompany(company);
            insurance.setCompany(company);
        }

        ParamBuilder pb = getPrincipalParam(principal);
        List<Folder> folders = userService.getListFolderByParams(pb.getParams());
        List<String> nameFolders = new ArrayList<String>();
        if (folders == null)
            folders = new ArrayList<Folder>();
        Iterator<Folder> iter = folders.iterator();

        while(iter.hasNext()) {
            String name = iter.next().getName();
            if (!"".equals(name))
                nameFolders.add(name);
        }

        insurance.setUser(userService.findByUsername(principal.getName()));
        insuranceService.saveOrUpdateInsurance(insurance);
        map.put("insurance", insurance);
        map.put("provider", insuranceCompanies);
        map.put("frequency", Frequency.values());
        map.put("bankaccount", bankAccountService.getListBankAccountByParams(getPrincipalParam(principal).getParams()));
        map.put("folders", nameFolders);

        return map;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/notes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Note> note(@RequestBody List<Note> notes, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        user.getInsurance().setNotes(notes);
        insuranceService.saveOrUpdateInsurance(user.getInsurance());
        return notes;
    }


    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/notes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Note> note(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user.getInsurance().getNotes();
    }


    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Address> getAddresses(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return user.getInsurance().getCompany().getAddresses();
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address getAddress(@PathVariable Long addressId){
        return insuranceService.getAddressById(addressId);
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/address/datatable", method = RequestMethod.GET)
    public View listAddress(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Address> addresses = insuranceService.getAddressByParams(param, getPrincipalParam(principal).getParams());
        model.addAttribute("data", addresses);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/address", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address createAddress(@RequestBody @Valid Address address, Principal principal, BindingResult result){
        if (result.hasErrors()){
            address.getJsonValues().put("success", "false");
            address.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        address.setCompany(company);
        insuranceService.saveOrUpdateAddress(address);
        address.getJsonValues().put("success", "true");
        return address;

    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/address", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address updateAddress(@RequestBody @Valid Address address, Principal principal, BindingResult result){
        if (result.hasErrors()){
            address.getJsonValues().put("success", "false");
            address.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        address.setCompany(company);
        insuranceService.saveOrUpdateAddress(address);
        address.getJsonValues().put("success", "true");
        return address;

    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address deleteAddress(@PathVariable Long addressId ){
        Address address = insuranceService.getAddressById(addressId);
        if (address != null){
            insuranceService.deleteAddress(address);
            address.getJsonValues().put("success", true);
        } else{
            address = new Address();
            address.getJsonValues().put("success", false);
            address.getJsonValues().put("message", "Not found an object with id = " + addressId);
        }
        return address;
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/phone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Phone> getPhones(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return user.getInsurance().getCompany().getPhones();
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/phone/{phoneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone getPhone(@PathVariable Long phoneId){
        return insuranceService.getPhoneById(phoneId);
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/phone/datatable", method = RequestMethod.GET)
    public View listPhone(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Phone> phones = insuranceService.getPhoneByParams(param, getPrincipalParam(principal).getParams());
        model.addAttribute("data", phones);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/phone", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone createPhone(@RequestBody @Valid Phone phone,Principal principal, BindingResult result){
        if (result.hasErrors()){
            phone.getJsonValues().put("success", "false");
            phone.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        phone.setCompany(company);
        insuranceService.saveOrUpdatePhone(phone);
        phone.getJsonValues().put("success", "true");
        return phone;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/phone", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone updatePhone(@RequestBody @Valid Phone phone,Principal principal, BindingResult result){
        if (result.hasErrors()){
            phone.getJsonValues().put("success", "false");
            phone.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        phone.setCompany(company);
        insuranceService.saveOrUpdatePhone(phone);
        phone.getJsonValues().put("success", "true");
        return phone;
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/phone/{phoneId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone deletePhone(@PathVariable Long phoneId ){
        Phone phone = insuranceService.getPhoneById(phoneId);
        if (phone != null){
            insuranceService.deletePhone(phone);
            phone.getJsonValues().put("success", true);
        } else {
            phone = new Phone();
            phone.getJsonValues().put("success", false);
            phone.getJsonValues().put("message", "Not found object with id = "+ phoneId);
        }
        return phone;
    }


    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Email> getemail(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return user.getInsurance().getCompany().getEmails();
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/email/{phoneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email getEmail(@PathVariable Long emailId){
        return insuranceService.getEmailById(emailId);
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/email/datatable", method = RequestMethod.GET)
    public View listEmail(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Email> emails = insuranceService.getEmailByParams(param, getPrincipalParam(principal).getParams());
        model.addAttribute("data", emails);
        return new JsonView();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @Transactional
    @RequestMapping(value = "/email", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email createEmail(@RequestBody @Valid Email email,Principal principal, BindingResult result){
        if (result.hasErrors()){
            email.getJsonValues().put("success", "false");
            email.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        email.setCompany(company);
        insuranceService.saveOrUpdateEmail(email);
        email.getJsonValues().put("success", "true");
        return email;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/email", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email updateEmail(@RequestBody @Valid Email email,Principal principal, BindingResult result){
        if (result.hasErrors()){
            email.getJsonValues().put("success", "false");
            email.getJsonValues().put("message", "Validation error");
        }
        Company company = userService.findByUsername(principal.getName()).getInsurance().getCompany();
        email.setCompany(company);
        insuranceService.saveOrUpdateEmail(email);
        email.getJsonValues().put("success", "true");
        return email;
    }

    @PreAuthorize(value= "isAuthenticated()")
    @RequestMapping(value = "/email/{emailId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email deleteEmail(@PathVariable Long emailId ){
        Email email = insuranceService.getEmailById(emailId);
        if (email != null){
            insuranceService.deleteEmail(email);
            email.getJsonValues().put("success", true);
        } else {
            email = new Email();
            email.getJsonValues().put("success", false);
            email.getJsonValues().put("message", "Not found object with id = "+ emailId);
        }
        return email;
    }
}
