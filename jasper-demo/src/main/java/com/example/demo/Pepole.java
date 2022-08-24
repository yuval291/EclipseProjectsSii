package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jasper_table")
public class Pepole {
	

	@Id
	@Column(name = "id")
	String id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "last_name")
	String last_name;
	
	

	public Pepole() {
		super();
	}

	public Pepole(String id, String name, String last_name) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	

}
