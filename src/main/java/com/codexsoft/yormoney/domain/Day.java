package com.codexsoft.yormoney.domain;

public enum Day {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");


    private String description;


    Day(String description){
        this.description = description;
    }

    private String getDescription() {
        return description;
    }

}
