package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "income_category")
public class IncomeCategory extends DomainObject {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incomeCategory")
    private List<IncomeType> incomeTypes;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<IncomeType> getIncomeTypes(){
        return incomeTypes;
    }

    public void setIncomeTypes(List<IncomeType> incomeTypes){
        this.incomeTypes = incomeTypes;
    }
}
