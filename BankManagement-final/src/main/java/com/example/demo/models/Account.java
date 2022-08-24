package com.example.demo.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column
	private long accountNumber;
	@Column
	private double currentBalance;
	@Column
	private double minusLimit;
	@Column
	private boolean active;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="owner_customer")
	private Customer customer;

	public Account(long accountNumber, double currentBalance, double minusLimit) {
		super();
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.minusLimit = minusLimit;
		this.active = true;
	}
	

	public Account(long accountNumber) {
		super();
		this.accountNumber = accountNumber;
		this.active = true;
	}

	public Account() {
		super();
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getMinusLimit() {
		return minusLimit;
	}

	public void setMinusLimit(double minusLimit) {
		this.minusLimit = minusLimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public void addCurrentBalance(int sum) {
		this.currentBalance = this.currentBalance+sum;
		
	}
	
	
}
