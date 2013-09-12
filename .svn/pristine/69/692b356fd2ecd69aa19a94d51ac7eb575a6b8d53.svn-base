package com.codexsoft.yormoney.domain;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family extends DomainObject  {

    private static final long serialVersionUID = -558999701L;

    transient public static final String[] colsPosition = {"id", "description"};

    @Basic( optional = false )
    @Column(name="description", nullable = false, length = 255)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
