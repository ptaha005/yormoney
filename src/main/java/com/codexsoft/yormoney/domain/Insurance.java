package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "insurance")
public class Insurance extends DomainObject{

    @Column
    private Frequency frequency;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column
    private String lifeAssuarence;

    @Column
    private String purpose;

    @Column
    private String cover;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name ="payment_amount")
    private Double paymentAmount;

    @JsonIgnore
    @GsonExclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "insurance")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_company_id")
    private InsuranceCompany insuranceCompany;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Note.class, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    private List<Note> notes;

    @JsonIgnore
    @GsonExclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLifeAssuarence() {
        return lifeAssuarence;
    }

    public void setLifeAssuarence(String lifeAssuarence) {
        this.lifeAssuarence = lifeAssuarence;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
