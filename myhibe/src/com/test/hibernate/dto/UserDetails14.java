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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.ericsson.hibernate.Address;

@Entity
@Table(name="User_14_Details")
public class UserDetails14 {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@OneToMany(mappedBy="user")
	//@JoinTable(name="User_Vehicle", joinColumns=@JoinColumn(name="UserID"), inverseJoinColumns=@JoinColumn(name="VehicleID"))
	private Collection<Vehicle14> vehicle = new ArrayList<Vehicle14>();
	
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
	public Collection<Vehicle14> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle14> vehicle) {
		this.vehicle = vehicle;
	}
	
}
