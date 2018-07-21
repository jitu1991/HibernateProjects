package com.test.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;

import com.ericsson.hibernate.Address;

@Entity
public class Student {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="Home_street")),
		@AttributeOverride(name="city", column=@Column(name="Home_City")),
		@AttributeOverride(name="pinCode", column=@Column(name="Home_pincode")),
		@AttributeOverride(name="state", column=@Column(name="Home_state"))
	})
	private Address homeAddress;
	private Address officeAddress;
	@ElementCollection
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	
}
