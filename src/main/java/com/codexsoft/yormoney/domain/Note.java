package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note extends DomainObject {

    private static final long serialVersionUID = -558999702L;

    transient public static final String[] colsPosition = {"i1d", "type", "description"};

    @Column
    private String description;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    @Column
    private String type;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Insurance.class)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Task.class)
    @JoinColumn(name = "task_id")
    private Task task;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
