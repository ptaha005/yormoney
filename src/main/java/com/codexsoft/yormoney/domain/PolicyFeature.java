package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//@Entity
//@Table(name = "policy_feature")
public class PolicyFeature extends DomainObject {

    @Column
    private String line;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="insurance_company_id")
    private InsuranceCompany insuranceCompany;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
