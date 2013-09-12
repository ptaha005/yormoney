package com.codexsoft.yormoney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: mikhail@codex-soft.com
 * Date: 7/9/13
 */

@Entity
@Table(name = "event_expenditure_level")
public class EventExpenditureLevel  extends DomainObject {

    private static final long serialVersionUID = -558999689L;

    @Column(name = "name", length = 50)
    private String name;

    @Column( name = "order_level" )
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
