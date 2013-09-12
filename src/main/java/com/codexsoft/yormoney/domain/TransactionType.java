package com.codexsoft.yormoney.domain;

public enum TransactionType {
    Income("Income"), Expenditure("Expenditure"), Event("Event"), Insurance("Insurance");

    private String name;

    TransactionType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
