package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event_type")
public class EventType extends DomainObject  {

	private static final long serialVersionUID = -558999691L;

    transient public static final String[] colsPosition = {"id", "name"};

    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;

    /*@ManyToOne(fetch = FetchType.LAZY )
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "event_id", nullable = true )
	private Event event;*/

    @Basic( optional = true )
    @Column( length = 30  )
	private String name;


    public Date getDate() {
		return this.date;
    }

	public void setDate(final Date date) {
		this.date = date;
	}

	/*public Event getEvent() {
		return this.event;
	}

	public void setEvent(final Event event) {
		this.event = event;
	}*/

	public String getName() {
		return this.name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("date: " + this.getDate() + ", ");
		sb.append("name: " + this.getName());
		return sb.toString();		
	}
}
