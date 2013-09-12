package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder")
public class Folder extends DomainObject {

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true,  mappedBy = "folder")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private List<Document> documents = new ArrayList<Document>();

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
