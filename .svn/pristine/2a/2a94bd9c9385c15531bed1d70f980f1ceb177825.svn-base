package com.codexsoft.yormoney.domain;


import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email extends DomainObject {

    @Column
    private String email;

    @Column
    private String name;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
