package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "income_type")
public class IncomeType extends DomainObject{

	private static final long serialVersionUID = -558999687L;

    transient public static final String[] colsPosition = {"id", "name"};

    @Column( length = 30  )
	private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "income_category_id")
    private IncomeCategory incomeCategory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
    }
}
