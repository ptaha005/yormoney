package com.codexsoft.yormoney.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.loader.ColumnEntityAliases;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "insurance_company")
public class InsuranceCompany extends DomainObject {
    @Column
    private String name;

    @Column
    private String payment_monthly;

    @Column(name = " policy_features")
    private String  policyFeatures;

    @Column(name = " payment_changes")
    private Boolean  paymentChanges;

//    @OneToMany(fetch = FetchType.EAGER)
//    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
//    private List<PolicyFeature> features;

    @Column(name = "path_file_policy")
    private String path_filePolicy;

    @Column(name = "path_image_brend")
    private String path_imageBrend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<PolicyFeature> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(List<PolicyFeature> features) {
//        this.features = features;
//    }

    public String getPath_filePolicy() {
        return path_filePolicy;
    }

    public void setPath_filePolicy(String path_filePolicy) {
        this.path_filePolicy = path_filePolicy;
    }

    public String getPath_imageBrend() {
        return path_imageBrend;
    }

    public void setPath_imageBrend(String path_imageBrend) {
        this.path_imageBrend = path_imageBrend;
    }

    public String getPayment_monthly() {
        return payment_monthly;
    }

    public void setPayment_monthly(String payment_monthly) {
        this.payment_monthly = payment_monthly;
    }

    public Boolean getPaymentChanges() {
        return paymentChanges;
    }

    public void setPaymentChanges(Boolean paymentChanges) {
        this.paymentChanges = paymentChanges;
    }

    public String getPolicyFeatures() {
        return policyFeatures;
    }

    public void setPolicyFeatures(String policyFeatures) {
        this.policyFeatures = policyFeatures;
    }
}
