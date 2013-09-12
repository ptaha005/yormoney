package com.codexsoft.yormoney.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank extends DomainObject  {

	private static final long serialVersionUID = -558999699L;

    transient public static final String[] colsPosition = {"id", "name"};

    @Basic( optional = false )
    @Column(name = "name", nullable = false, length = 100  )
    private String name;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("name: " + this.getName());
		return sb.toString();		
	}
}
