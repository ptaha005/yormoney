package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "balance")
public class Balance extends DomainObject {


    @JsonProperty(value = "Result")
    @Column(name = "total")
    private Long total = 0L;

    @JsonProperty(value = "In")
    @Column(name="total_income")
    private Long totalIncome = 0L;

    @JsonProperty(value = "Out")
    @Column(name = "total_expenditure")
    private Long totalExpennditure = 0L;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Long getTotalExpennditure() {
        return totalExpennditure;
    }

    public void setTotalExpennditure(Long totalExpennditure) {
        this.totalExpennditure = totalExpennditure;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
