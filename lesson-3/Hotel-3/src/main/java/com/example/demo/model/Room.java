package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column
	private int roomNumber;
	@Column
	private int floor;
	@Column
	private Date occupiedSince;
	@Column
	private Date occupiedUntil;
	
	@OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER)
	private List<Customer> occupiedBy;

	public Room(int roomNumber, int floor, Date occupiedSince, Date occupiedUntil, List<Customer> occupiedBy) {
		super();
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.occupiedSince = occupiedSince;
		this.occupiedUntil = occupiedUntil;
		this.occupiedBy = occupiedBy;
	}

	public Room() {
		super();
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Date getOccupiedSince() {
		return occupiedSince;
	}

	public void setOccupiedSince(Date occupiedSince) {
		this.occupiedSince = occupiedSince;
	}

	public Date getOccupiedUntil() {
		return occupiedUntil;
	}

	public void setOccupiedUntil(Date occupiedUntil) {
		this.occupiedUntil = occupiedUntil;
	}

	public List<Customer> getOccupiedBy() {
		return occupiedBy;
	}

	public void setOccupiedBy(List<Customer> occupiedBy) {
		this.occupiedBy = occupiedBy;
	}
	
	
}
