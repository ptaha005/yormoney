package com.codexsoft.yormoney.controller;

import com.codexsoft.yormoney.AbstractContextControllerTests;
import com.codexsoft.yormoney.domain.Document;
import com.codexsoft.yormoney.domain.Folder;
import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.UserService;
import com.codexsoft.yormoney.util.datatables.ParamBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class UserControllerTest extends AbstractContextControllerTests {

    private final Logger log = Logger.getLogger(UserControllerTest.class);

    @Autowired
    UserService userService;
    @Test
    public void signin() throws Exception{
        SecurityContextHolder.clearContext();
        log.info("Class UserController, method - /user/signin POST, testing");
        String content = "{\"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}";

        ResultActions ra = this.mockMvc.perform(post("/user/signin").content(content).contentType(MediaType.APPLICATION_JSON));

        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void logout() throws Exception{
        log.info("Class UserController, method - /user/logout GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/logout").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE+";charset=ISO-8859-1"));

    }

    @Test
    @Transactional
    @Rollback
    public void state()throws Exception{
        log.info("Class UserController, method - /user/state/{value} GET, testing");

        String str[] = {"nothing","register1","welcome","register2","bankaccounts",
        "income","expenditure","events","summary","complite"};
        for(String s:str){
            ResultActions ra =this.mockMvc.perform(get("/user/state/{value}",s).principal(auth).contentType(MediaType.APPLICATION_JSON));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Test
    public void getUserInfo()throws Exception{
        log.info("Class UserController, method - /user/getUserInfo GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/getUserInfo").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getMembers()throws Exception{
        log.info("Class UserController, method - /user/members/list GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/members/list").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getRelationship()throws Exception{
        log.info("Class UserController, method - /user/getRelationships GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/getRelationships").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void forgotPassword()throws Exception{
        log.info("Class UserController, method - /user/forgot/password POST, testing");
        User user = userService.findByUsername(username);
        String content = "{\"email\":\""+user.getEmail()+"\"}";
        ResultActions ra = this.mockMvc.perform(post("/user/forgot/password").content(content).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void forgotUsername()throws Exception{
        log.info("Class UserController, method - /user/forgot/username POST, testing");
        User user = userService.findByUsername(username);
        String content = "{\"email\":\""+user.getEmail()+"\"}";
        ResultActions ra = this.mockMvc.perform(post("/user/forgot/username").content(content).contentType(MediaType.APPLICATION_JSON));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void session()throws Exception{
        log.info("Class UserController, method - /user/session GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/session").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void uploadFile()throws Exception{
        log.info("Class UserController, method - /user/uploadFile POST, testing");

        String content = "HELLO MY FRIEND";
        ResultActions ra = this.mockMvc.perform(fileUpload("/user/uploadFile").content(content.getBytes()).principal(auth)
       .param("path","")
       .param("qqfile","test.txt"));
        ra.andExpect(status().isOk());

    }

    @Test
    public void fileRoot()throws Exception{
        log.info("Class UserController, method - /user/file/0 GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/file/0").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @Rollback
    public void file()throws Exception{
        log.info("Class UserController, method - /user/file/{folderId} GET, testing");
        User user = userService.findByUsername(username);
        ParamBuilder paramBuilder = ParamBuilder.getBuilder();
        paramBuilder.equal("user",user);
        List<Folder> folders = userService.getListFolderByParams(paramBuilder.getParams());

        if(folders.size()>0){
            Folder folder = folders.get(0);
            log.info("Url /user/file/" + folder.getId());
            ResultActions ra = this.mockMvc.perform(get("/user/file/{folderId}",folder.getId()).principal(auth));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } else{
            log.info("User -" + username +  "  has no folders, to test the method - /user/file/{folderId}");
        }
    }

    @Test
    @Transactional
    @Rollback
    public void deleteFile()throws Exception{
        log.info("Class UserController, method - /user/file DELETE, testing");

        User user = userService.findByUsername(username);
        ParamBuilder paramBuilder = ParamBuilder.getBuilder();
        paramBuilder.equal("user",user);
        List<Document> documents = userService.getListDocumentByParams(paramBuilder.getParams());

        if(documents.size()>0){
            Document document = documents.get(0);
            log.info("Url /user/file param: fileId = " + document.getId());

            ResultActions ra = this.mockMvc.perform(delete("/user/file")
                    .param("fileId", String.valueOf(document.getId())).principal(auth));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE+";charset=ISO-8859-1"));
        } else{
            log.info("User -" + username +  "  has no document, to test the method - /user/file");
        }

    }

    @Test
    @Transactional
    @Rollback
    public void deleteFolder()throws Exception{
        log.info("Class UserController, method - /user/folder DELETE, testing");
        User user = userService.findByUsername(username);
        ParamBuilder paramBuilder = ParamBuilder.getBuilder();
        paramBuilder.equal("user",user);
        List<Folder> folders = userService.getListFolderByParams(paramBuilder.getParams());

        if(folders.size()>0){
            Folder folder = folders.get(0);
            log.info("Url /user/file  param ="  + folder.getId());
            ResultActions ra = this.mockMvc.perform(delete("/user/folder")
                    .param("folderId",String.valueOf(folder.getId())).principal(auth));
            ra.andExpect(status().isOk());
            ra.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE+";charset=ISO-8859-1"));
        } else{
            log.info("User -" + username +  "  has no folders, to test the method - /user/file/{folderId}");
        }
    }

    @Test
    @Transactional
    @Rollback
    public void createFolder()throws Exception{
        log.info("Class UserController, method - /user/folder/{folderNmae} POST, testing");
        ResultActions ra = this.mockMvc.perform(post("/user/folder/TEST").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void folder()throws Exception{
        log.info("Class UserController, method - /user/folders GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/folders").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public  void note()throws Exception{
        log.info("Class UserController, method - /user/notes GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/notes").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public  void balance()throws Exception{
        log.info("Class UserController, method - /user/total GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/total").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void userState()throws Exception{
        log.info("Class UserController, method - /user/state GET, testing");
        ResultActions ra = this.mockMvc.perform(get("/user/state").principal(auth));
        ra.andExpect(status().isOk());
        ra.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE+";charset=ISO-8859-1"));
    }







}
