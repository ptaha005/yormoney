package com.codexsoft.yormoney.domain;


import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.*;

@Entity
@Table(name = "document")
public class Document extends DomainObject{

    @Column
    private String name;

    @Column(name = "system_name")
    private String systemName;

    @Column
    private String path;

    @Column
    private DocumentType type;

    @Column
    private String category;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Folder.class)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public void setTypeFrom(File file)
    {
        String fileName = file.getName();
        String[] parts = fileName.split(".");
        if (parts.length < 2) {
            this.type = DocumentType.other;
        } else {
            String ext = parts[1].toUpperCase();    
            if (ext == ".pdf") this.type = DocumentType.pdf;
            else if (ext == ".xls") this.type = DocumentType.xls;
            else this.type = DocumentType.other;

                //report cover
                //pdf, doc, xml, java, jpg,png, none
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
