package com.codexsoft.yormoney.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends DomainObject implements GrantedAuthority {

	private static final long serialVersionUID = -558999683L;

    transient public static final String[] colPositon = {"id", "name"};

    @Basic( optional = false )
    @Column(name="name", nullable = false, length = 20  )
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
		sb.append("name: " + this.getName() + ", ");
		return sb.toString();		
	}

    @Override
    public String getAuthority() {
        return name;
    }
}
