package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.codexsoft.yormoney.jsonserializers.JsonDeserializerDate;
import com.codexsoft.yormoney.jsonserializers.JsonSerializerDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member extends DomainObject {

	private static final long serialVersionUID = -558999686L;

    transient public static final String[] colsPosition = {"id", "lastname", "firstName", "address"};

    @Column( name = "account_holder"  )
	private Boolean accountHolder;

    @Column( name = "email")
    private String email;

    @Column(length = 80)
	private String address;

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "member"  )
	private List<BankAccount> bankAccounts;

    @GsonExclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "family_id")
    private Family family;

    @Column( name = "date_of_birth")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "UTC")
    @JsonDeserialize(using = JsonDeserializerDate.class)
    @JsonSerialize(using = JsonSerializerDate.class)
	private Date dateOfBirth;

    @Column(name = "occupation", length = 150)
    private String occupation;

    @JsonIgnore
    @GsonExclude
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "member")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
	private List<Expenditure> expenditures;

    @Column( name = "first_name", length = 30  )
	private String firstName;

    @JsonIgnore
    @GsonExclude
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "member")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
	private List<Income> incomes;

    @Column( name = "last_name", length = 30  )
	private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relationship_id")
	private Relationship relationship;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	public void addBankAccount(BankAccount bankAccount) {
		bankAccount.setMember(this);
		this.bankAccounts.add(bankAccount);
	}

	public void setBankAccounts(final List<BankAccount> bankAccount) {
		this.bankAccounts = bankAccount;
	}




	public List<Expenditure> getExpenditures() {
		return this.expenditures;
	}

	public void addExpenditure(Expenditure expenditure) {
		expenditure.setMember(this);
		this.expenditures.add(expenditure);
	}

	public void setExpenditures(final List<Expenditure> expenditure) {
		this.expenditures = expenditure;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}


	public List<Income> getIncomes() {
		return this.incomes;
	}

	public void addIncome(Income income) {
		income.setMember(this);
		this.incomes.add(income);
	}

	public void setIncomes(final List<Income> income) {
		this.incomes = income;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}


	public Relationship getRelationship() {
		return this.relationship;
	}

	public void setRelationship(final Relationship relationship) {
		this.relationship = relationship;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Boolean isAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(final Boolean accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
