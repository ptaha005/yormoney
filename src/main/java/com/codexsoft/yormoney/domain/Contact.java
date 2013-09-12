package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact extends DomainObject {

    private static final long serialVersionUID = -558999701L;

    transient public static final String[] colsPosition = {"id", "name", "address"};

    @Column(length = 100)
    private String name;

    @Column(length = 50)
    private String phone;

    @Column(length = 50)
    private String email;

    @Column(length = 80)
    private String address;

    @Column(length = 80)
    private String webaddress;

    @Column( name = "date_of_birth")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    @Column (length = 200)
    private String fotopath;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    @Fetch(FetchMode.SELECT)
    private List<Note> note;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("address: " + this.getAddress() + ", ");
        return sb.toString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFotopath() {
        return fotopath;
    }

    public void setFotopath(String fotopath) {
        this.fotopath = fotopath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
