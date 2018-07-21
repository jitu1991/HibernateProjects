package com.test.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.ericsson.hibernate.Address;

@Entity
@Table(name="User_13_Details")
public class UserDetails13 {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@OneToOne
	@JoinColumn(name="Vehicle_Id")
	private Vehicle13 vehicle;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Vehicle13 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle13 vehicle) {
		this.vehicle = vehicle;
	}
}
