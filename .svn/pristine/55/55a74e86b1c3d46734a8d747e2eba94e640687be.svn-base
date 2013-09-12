package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "income")
public class Income extends DomainObject {

	private static final long serialVersionUID = -558999688L;

    transient public static final String[] colsPosition = {"id", "amount", "frequency", "incomeSource", "bankAccount", "paidDateDay"};

    @Column(name="active")
	private Boolean active;

    @Column(name="amount")
	private Integer amount;

    @Column(name="frequency", length = 30  )
	private String frequency;

    @Column( name = "income_source", length = 30  )
	private String incomeSource;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "income_type_id")
	private IncomeType incomeType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
	private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paid_A_C")
  	private BankAccount bankAccount;

    @Column( name = "paid_date_day"  )
	private Integer paidDateDay;

    @Column(name="question", length = 30  )
    private String question;

    @GsonExclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id")
	private User user;

    @Basic( optional = true )
    @Column(name="paid_on" )
    private Date paidOn;

    @Basic( optional = true )
    @Column(name="paid_on_day" )
    private Boolean paidOnDay;

    @Basic( optional = true )
    @Column(name="paid_day" )
    private Day day;

	public void setActive(final Boolean active) {
		this.active = active;
	}

    public Boolean getActive() {
        return active;
    }

	public Integer getAmount() {
		return this.amount;
		
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}


	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(final String frequency) {
		this.frequency = frequency;
	}


	public String getIncomeSource() {
		return this.incomeSource;
	}

	public void setIncomeSource(final String incomeSource) {
		this.incomeSource = incomeSource;
	}


	public IncomeType getIncomeType() {
		return this.incomeType;
	}

	public void setIncomeType(final IncomeType incomeType) {
		this.incomeType = incomeType;
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
		sb.append("amount: " + this.getAmount() + ", ");
		sb.append("frequency: " + this.getFrequency() + ", ");
		sb.append("incomeSource: " + this.getIncomeSource() + ", ");
		sb.append("paidDateDay: " + this.getPaidDateDay() + ", ");
		return sb.toString();		
	}

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

    public Date getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
