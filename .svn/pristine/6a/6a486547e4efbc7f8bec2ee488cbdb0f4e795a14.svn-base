package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.codexsoft.yormoney.jsonserializers.JsonDeserializerDate;
import com.codexsoft.yormoney.jsonserializers.JsonSerializerDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task extends DomainObject {

    private static final long serialVersionUID = -558999701L;

    transient public static final String[] colsPosition = {"id", "name", "address"};

    @Column(length = 100)
    private String title;

    @Column(length = 50)
    private String linkTo;

    @Column(name = "start_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "UTC")
    @JsonDeserialize(using = JsonDeserializerDate.class)
    @JsonSerialize(using = JsonSerializerDate.class)
    private Date startDate;

    @Column(name = "due_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "UTC")
    @JsonDeserialize(using = JsonDeserializerDate.class)
    @JsonSerialize(using = JsonSerializerDate.class)
    private Date dueDate;

    @Column
    private Integer complete;

    @Column
    private Integer reminder;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "task_id")
    @Fetch(FetchMode.SELECT)
    private List<Note> notes;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getReminder() {
        return reminder;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
