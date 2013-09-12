package com.codexsoft.yormoney.util.datatables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DatatablesStructure<T> implements Serializable{

    @JsonProperty(value = "iTotalRecords")
    public int totalRecords;

    @JsonProperty(value = "iTotalDisplayRecords")
    public int totalDisplayRecords;

    @JsonProperty(value = "sEcho")
    public String echo;

    @JsonIgnore
    public String columns;

    public TimeZone timeZone;

    @JsonProperty(value = "aaData")
    public List<T> data = new ArrayList<T>();

    public DatatablesStructure() {
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalDisplayRecords() {
        return totalDisplayRecords;
    }

    public void setTotalDisplayRecords(int totalDisplayRecords) {
        this.totalDisplayRecords = totalDisplayRecords;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
