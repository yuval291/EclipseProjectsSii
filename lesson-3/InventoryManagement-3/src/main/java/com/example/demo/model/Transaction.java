package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name="Transaction")
@Entity
public class Transaction {
	
	@Id
	@Column(name = "transaction_id")
	private Integer transactionId;
	
	@Column(name = "transaction_date")
	private String transactionDate;
	
	@Column(name = "transaction_cost")
	private Double transactionCost;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "transaction_products",
			joinColumns = @JoinColumn(
					name = "product_code"), 
			inverseJoinColumns = @JoinColumn(name = "transaction_id"))
	Set<Product> products;
	
	public Transaction(Integer transactionId, String transactionDate, Double transactionCost) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionCost = transactionCost;
		this.products = new HashSet<Product>();
	}

	public Transaction() {
	}
	
	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionId);
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTransactionCost() {
		return transactionCost;
	}

	public void setTransactionCost(Double transactionCost) {
		this.transactionCost = transactionCost;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
