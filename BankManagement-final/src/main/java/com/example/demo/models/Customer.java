package com.example.demo.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column
	private long customerId;
	@Column
	private String fullName;
	@Column
	private String mail;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="owner_customer",referencedColumnName = "customerId")
	@JsonManagedReference
	private Set<Account> bankAccounts;
	
	@JsonManagedReference
  	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private List<Loan> loans;

	public Customer(long customerId, String fullName, String mail) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.mail = mail;
	}

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Account> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Set<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	
}
