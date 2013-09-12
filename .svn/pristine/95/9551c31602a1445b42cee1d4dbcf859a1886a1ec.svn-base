package com.codexsoft.yormoney.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_type")
public class AccountType extends DomainObject {

	private static final long serialVersionUID = -558999700L;

    transient public static final String[] colsPosition = {"id", "name"};

    @Column
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
