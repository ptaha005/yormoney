package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends DomainObject {

	private static final long serialVersionUID = -558999696L;

    transient public static final String[] colsPosition = {"id", "name"};

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenditure_list_id", nullable = false)
    private ExpenditureList expenditureList;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "category"  )
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.SELECT)
	private List<ExpenditureType> expenditureTypes;

    @Column(name = "name", nullable = false, length = 30  )
	private String name;

	public List<ExpenditureType> getExpenditureTypes() {
		return this.expenditureTypes;
	}
	
	public void addExpenditureType(ExpenditureType expenditureType) {
		expenditureType.setCategory(this);
		this.expenditureTypes.add(expenditureType);
	}

	public void setExpenditureTypes(final List<ExpenditureType> expenditureType) {
		this.expenditureTypes = expenditureType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

    public ExpenditureList getExpenditureList() {
        return expenditureList;
    }

    public void setExpenditureList(ExpenditureList expenditureList) {
        this.expenditureList = expenditureList;
    }
}
