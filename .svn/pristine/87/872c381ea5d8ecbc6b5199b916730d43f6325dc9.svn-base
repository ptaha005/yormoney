package com.codexsoft.yormoney.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "relationship")
public class Relationship extends DomainObject {

	private static final long serialVersionUID = -558999684L;

    transient public static final String[]  colPosition = {"id", "name"};

    @Basic( optional = true )
    @Column(name="name", length = 30  )
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
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName());
		return sb.toString();		
	}
}
