package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car")
public class Car {	
	
	@Id
	@Column
	private String carType;
	@Column
	private String color;
	@Column
	private long mileage;
	@Column
	private int yearOfManufacture;
	@Column
	private int numberOfPreviousOwners;
	@Column
	private long price;
	
	public Car(String carType, String color, long mileage, int yearOfManufacture, int numberOfPreviousOwners,
			long price) {
		super();
		this.carType = carType;
		this.color = color;
		this.mileage = mileage;
		this.yearOfManufacture = yearOfManufacture;
		this.numberOfPreviousOwners = numberOfPreviousOwners;
		this.price = price;
	}

	public Car() {
		super();
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getMileage() {
		return mileage;
	}

	public void setMileage(long mileage) {
		this.mileage = mileage;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public int getNumberOfPreviousOwners() {
		return numberOfPreviousOwners;
	}

	public void setNumberOfPreviousOwners(int numberOfPreviousOwners) {
		this.numberOfPreviousOwners = numberOfPreviousOwners;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [carType=" + carType + ", color=" + color + ", Mileage=" + mileage + ", yearOfManufacture="
				+ yearOfManufacture + ", numberOfPreviousOwners=" + numberOfPreviousOwners + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}
