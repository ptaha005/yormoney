package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "bank_account")
public class BankAccount extends DomainObject {

	private static final long serialVersionUID = -558999698L;

    transient public static final String[] colPosition = {"id", "balance", "purpose"};

    @Column(name="purpose", length = 50  )
    private String purpose;

    @Column(name="balance")
    private Integer balance;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "account_type_id")
	private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id")
	private Bank bank;

    @GsonExclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
	private Member member;

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, targetEntity  = Transaction.class, mappedBy = "bankAccount"  )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
	private List<Transaction> transactions;

	public AccountType getAccountType() {
		return this.accountType;
	}
	
	public void setAccountType(final AccountType accountType) {
		this.accountType = accountType;
	}

	public Integer getBalance() {
		return this.balance;
	}
	
	public void setBalance(final Integer balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(final Bank bank) {
		this.bank = bank;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(final Member member) {
		this.member = member;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(final String purpose) {
		this.purpose = purpose;
	}


	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setBankAccount(this);
		this.transactions.add(transaction);
	}

	public void setTransactions(final List<Transaction> transaction) {
		this.transactions = transaction;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
        sb.append("id: " + this.getId() + ", ");
		sb.append("balance: " + this.getBalance() + ", ");
		sb.append("purpose: " + this.getPurpose() + ", ");
		return sb.toString();		
	}
}
