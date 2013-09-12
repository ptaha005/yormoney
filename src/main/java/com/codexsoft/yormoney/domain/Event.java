package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "event")
public class Event extends DomainObject {

	private static final long serialVersionUID = -558999695L;

    transient public static final String[] colPosition = {"id", "active", "date"};

    @Column(name="active")
   	private Boolean active;

    @Column( name = "agreed_spend"  )
	private Integer agreedSpend;

    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "event_expenditure_type")
	private EventExpenditureType eventExpenditureType;

    @GsonExclude
    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id", nullable = true )
	private User user;


	public Integer getAgreedSpend() {
		return this.agreedSpend;
	}
	
	public void setAgreedSpend(final Integer agreedSpend) {
		this.agreedSpend = agreedSpend;
	}

	public Date getDate() {
		return this.date;
	}
	
	public void setDate(final Date date) {
		this.date = date;
	}


    public EventExpenditureType getEventExpenditureType() {
        return eventExpenditureType;
    }

    public void setEventExpenditureType(EventExpenditureType eventExpenditureType) {
        this.eventExpenditureType = eventExpenditureType;
    }

    public User getUser() {
		return this.user;
	}
	
	public void setUser(final User user) {
		this.user = user;
	}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
