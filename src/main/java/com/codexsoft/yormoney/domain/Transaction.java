package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction extends DomainObject {

	private static final long serialVersionUID = -558999682L;

    transient public static final String[] colPosition = {"id", "description" , "date"};

    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    @Column
    private Long number;

    @Column( length = 20  )
    private String description;

    @Column
    private String type;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "bank_account")
	private BankAccount bankAccount;

    @JsonIgnore
    @GsonExclude
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id")
	private User user;

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("date: " + this.getDate() + ", ");
		sb.append("description: " + this.getDescription() + ", ");
		return sb.toString();
	}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
