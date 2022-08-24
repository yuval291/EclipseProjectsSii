package com.example.demo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Table(name="Product")
@Entity
public class Product {

	@Id
	@Column(name = "product_code")
	private Integer productCode;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_amount")
	private Integer productAmount;
	
	@Column(name = "product_price")
	private double price;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private Set<Transaction> transaction;
	
	public Product(String productName, Integer productCode, Integer amount, double price) {
		this.productName =productName;
		this.productCode = productCode;
		this.productAmount=amount;
		this.price=price;
		this.transaction = new HashSet<Transaction>();
	}
	
	public Product() {	
	}
	
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productAmount="
				+ productAmount + ", productPrice=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(productCode);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	
	

}
