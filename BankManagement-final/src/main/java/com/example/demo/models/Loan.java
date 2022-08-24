package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Loan {

	@Id
    @Column
	private int loanNumber;
	@Column
	private double amount;
	@Column
	private boolean status;
	@Column
	private int interest;
	@Column
	private double monthlyRepayment;
	@Column
	private long accountNumber;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Loan(int loanNumber, double amount, boolean status, int interest, double monthlyRepayment, long accountNumber,
			Customer customer) {
		super();
		this.loanNumber = loanNumber;
		this.amount = amount;
		this.status = status;
		this.interest = interest;//ribit
		this.monthlyRepayment = monthlyRepayment;//החזר חודשי
		this.accountNumber = accountNumber;
		this.customer = customer;
	}
	
	

}
