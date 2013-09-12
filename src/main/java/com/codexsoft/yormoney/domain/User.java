package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.forms.RegistrationForm;
import com.codexsoft.yormoney.jsonserializers.GsonExclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends DomainObject implements UserDetails {

    transient public static final String[] colsPosition = {"id", "firstName", "lastName", "role"};

	private static final long serialVersionUID = -558999681L;

    @Size(min=2, max=50, message="{user.username}")
    @Column( name="username", nullable = false, length = 30  )
    private String username;

    @Column( name = "activation_code", length = 20  )
	 private String activationCode;

    // @Size(min=2, max=150, message="{user.address}")
    @Column(name="address", length = 80)
	private String address;

    @Email(message="{user.email}")
    @Column(name="email" , length = 30  )
	private String email;

    @Size(min=2, max=50, message="{user.lastName}")
    @Column( name = "last_name", nullable = false, length = 30  )
    private String lastName;

    @Size(min=2, max=50, message="{user.firstName}")
    @Column( name = "first_name", length = 30  )
    private String firstName;

    @Size(min=6, max=50, message="{user.password}")
    @Column(name="password")
    private String password;

    transient private String confirmPassword;

    @Column(name="postcode")
    private String postcode;

    @ManyToOne(optional = false, fetch = FetchType.EAGER )
    @JoinColumn(name = "role_id", nullable = false )
    private Role role;

    @Column(name="dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirthday;

    @Column(name="occupation")
    private String occupation;

    @Column(name="state")
    private Integer state = 0;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "token")
    private String token;

    private String describeState = State.nothing.getName();

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, targetEntity = Event.class,  mappedBy = "user"  )
    @Cascade({CascadeType.DELETE})
	private List<Event> events;

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, targetEntity = Expenditure.class, mappedBy = "user"  )
    @Cascade({CascadeType.DELETE})
	private List<Expenditure> expenditures;

    @GsonExclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Income.class, mappedBy = "user"  )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
	private List<Income> incomes;

    @GsonExclude
    @OneToMany( fetch = FetchType.EAGER, targetEntity = Member.class, mappedBy = "user"  )
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Member> members;

    @GsonExclude
    @JsonIgnore
    @OneToOne( fetch = FetchType.LAZY, targetEntity = Insurance.class, mappedBy = "user"  )
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Insurance insurance;

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, targetEntity = Transaction.class, mappedBy = "user"  )
    @Cascade({CascadeType.DELETE})
	private List<Transaction> transactions;

    @GsonExclude
    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, targetEntity = Transaction.class, mappedBy = "user"  )
    @Cascade({CascadeType.DELETE})
    private List<Contact> contacts;


    public String getActivationCode() {
		return this.activationCode;
	}
	
	public void setActivationCode(final String activationCode) {
		this.activationCode = activationCode;
	}

	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(final String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
		
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}

	public List<Event> getEvents() {
		return this.events;
	}
	
	public void addEvent(Event event) {
		event.setUser(this);
		this.events.add(event);
	}

	public void setEvents(final List<Event> event) {
		this.events = event;
	}

	public List<Expenditure> getExpenditures() {
		return this.expenditures;
		
	}
	
	public void addExpenditure(Expenditure expenditure) {
		expenditure.setUser(this);
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
		income.setUser(this);
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

	public List<Member> getMembers() {
		return this.members;
	}

	public void addMember(Member member) {
		member.setUser(this);
		this.members.add(member);
	}

	public void setMembers(final List<Member> member) {
		this.members = member;
	}

    public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(final String postcode) {
		this.postcode = postcode;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setUser(this);
		this.transactions.add(transaction);
	}

	public void setTransactions(final List<Transaction> transaction) {
		this.transactions = transaction;
	}

	public String getUsername() {
		return this.username;
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("activationCode: " + this.getActivationCode() + ", ");
		sb.append("address: " + this.getAddress() + ", ");
		sb.append("email: " + this.getEmail() + ", ");
		sb.append("firstName: " + this.getFirstName() + ", ");
		sb.append("lastName: " + this.getLastName() + ", ");
		sb.append("password: " + this.getPassword() + ", ");
		sb.append("postcode: " + this.getPostcode() + ", ");
		sb.append("username: " + this.getUsername());
		return sb.toString();		
	}

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        if (state > this.state)
            this.state = state;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getDescribeState() {
    	if (state == null)
    		return "register1";
    	return State.values()[state].getName();
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
