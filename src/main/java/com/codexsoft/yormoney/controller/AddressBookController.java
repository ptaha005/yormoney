package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.domain.Contact;
import com.codexsoft.yormoney.domain.Task;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.ContactService;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.DataTablesParamUtility;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.codexsoft.yormoney.util.datatables.JQueryDataTableParamModel;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
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
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequestMapping(value = {"/addressbook", "/api/addressbook"})
@Controller
public class AddressBookController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    public ParamBuilder getPrincipalParam(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ParamBuilder pb = ParamBuilder.getBuilder();
        pb.equal("user", user);
        return pb;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contact add(@RequestBody @Valid Contact contact, Principal principal, BindingResult result){
        contact.setUser(userService.findByUsername(principal.getName()));
        if (result.hasErrors()){
            contact.getJsonValues().put("success" , "false");
            contact.getJsonValues().put("message", "Validation erros");
            return contact;
        }
        contactService.saveOrUpdateContact(contact);
        contact.getJsonValues().put("success", "true");
        return contact;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contact delete(@RequestBody Map<String, Long> mapJSON){
        Long id = mapJSON.get("id");
        Contact contact = contactService.getContactById(id);
        if (contact == null){
            contact = new Contact();
            contact.getJsonValues().put("success", "false");
            contact.getJsonValues().put("message", "Not present in the database");
            return contact;
        }
        contactService.deleteContact(contact);
        contact.getJsonValues().put("message", "true");
        return contact;
    }

    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/list/{firstletter}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Contact> listByFirstLetter(@PathVariable String firstletter, Principal principal){
        ParamBuilder pb = getPrincipalParam(principal);
        pb.like("name", firstletter +"%");
        return contactService.getContactListByParams(pb.getParams());
    }

    @Transactional
    @PreAuthorize(value = "isAuthenticated()")
    @RequestMapping(value = "/listTask", method = RequestMethod.GET)
    public View listTask(Model model, HttpServletRequest request, Principal principal){
        JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
        DatatablesStructure<Contact> contacts = contactService.getTaskByParams(param, getPrincipalParam(principal).getParams());
        model.addAttribute("data", contacts);
        return new JsonView();
    }
}
