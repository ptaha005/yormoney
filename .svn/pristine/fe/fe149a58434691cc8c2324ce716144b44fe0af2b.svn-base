package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company extends DomainObject{

    @Column
    private String name;

    @JsonIgnore
    @GsonExclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<Address> addresses = new ArrayList<Address>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<Email> emails = new ArrayList<Email>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<Phone> phones = new ArrayList<Phone>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
