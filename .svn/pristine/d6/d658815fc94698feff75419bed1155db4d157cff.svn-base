package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "expenditure_type")
public class ExpenditureType extends DomainObject {

	private static final long serialVersionUID = -558999689L;

    transient public static final String[] colsPosition = {"id", "name"};

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
	private Category category;

    @Column( length = 50  )
	private String name;

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
