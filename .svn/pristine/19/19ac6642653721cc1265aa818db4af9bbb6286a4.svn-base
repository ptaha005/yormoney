package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expenditure_list")
public class ExpenditureList extends DomainObject {

    transient public static final String[] colsPosition = {"id", "name"};

    @Column(name = "name", nullable = false, length = 30  )
    private String name;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "expenditureList"  )
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.SELECT)
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
