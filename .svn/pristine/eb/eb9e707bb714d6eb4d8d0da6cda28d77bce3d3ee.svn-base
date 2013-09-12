package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenditure")
public class Expenditure extends DomainObject {

	private static final long serialVersionUID = -558999690L;

    transient public static final String[] colsPosition = {"id", "companyName", "cost", "frequence"};

    @Column(name="active")
	private Boolean active;

    @Column( name = "company_name", length = 30  )
	private String companyName;

    @Column(name="cost")
	private Integer cost;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "expenditure_type_id")
	private ExpenditureType expenditureType;

    @Column(name="frequency", length = 30  )
	private String frequency;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "member_id")
	private Member member;

    @Column( name = "paid_date_day"  )
	private Integer paidDateDay;
/*
    @Column( name = "paid_from_a_c", length = 30  )
	private String paidFromAC;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paid_from_a_c")
    private BankAccount bankAccount;

    @GsonExclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id")
	private User user;

    @Column(name="question", length = 30  )
  	private String question;

    @Column(name="paid_on" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  	private Date paidOn;

    @Column(name="paid_on_day" )
  	private Boolean paidOnDay;

    @Column(name="paid_day" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Day day;

    public Boolean getPaidOnDay() {
        return paidOnDay;
    }

    public void setPaidOnDay(Boolean paidOnDay) {
        this.paidOnDay = paidOnDay;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
    }

    public String getCompanyName() {
		return this.companyName;
		
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public Integer getCost() {
		return this.cost;
		
	}

	public void setCost(final Integer cost) {
		this.cost = cost;
	}


	public ExpenditureType getExpenditureType() {
		return this.expenditureType;
		
	}

	public void setExpenditureType(final ExpenditureType expenditureType) {
		this.expenditureType = expenditureType;
	}


	public String getFrequency() {
		return this.frequency;
		
	}

	public void setFrequency(final String frequency) {
		this.frequency = frequency;
	}


	public Member getMember() {
		return this.member;
		
	}

	public void setMember(final Member member) {
		this.member = member;
	}


	public Integer getPaidDateDay() {
		return this.paidDateDay;
		
	}

	public void setPaidDateDay(final Integer paidDateDay) {
		this.paidDateDay = paidDateDay;
	}

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
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
		sb.append("active: " + this.getActive() + ", ");
		sb.append("companyName: " + this.getCompanyName() + ", ");
		sb.append("cost: " + this.getCost() + ", ");
		sb.append("frequency: " + this.getFrequency() + ", ");
		sb.append("paidDateDay: " + this.getPaidDateDay() + ", ");
		return sb.toString();		
	}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
