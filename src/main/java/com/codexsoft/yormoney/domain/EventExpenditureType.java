package com.codexsoft.yormoney.domain;

import javax.persistence.*;


@Entity
@Table(name = "event_expenditure_type")
public class EventExpenditureType extends DomainObject {

	private static final long serialVersionUID = -558999689L;

    transient public static final String[] colsPosition = {"id", "name"};

    @Column( length = 50  )
	private String name;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "level_id", nullable = false)
    private EventExpenditureLevel level;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "type_id", nullable = true)
    private EventExpenditureType parentType;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

    public EventExpenditureLevel getLevel() {
        return level;
    }

    public void setLevel(EventExpenditureLevel level) {
        this.level = level;
    }

    public EventExpenditureType getParentType() {
        return parentType;
    }

    public void setParentType(EventExpenditureType parentType) {
        this.parentType = parentType;
    }
}
