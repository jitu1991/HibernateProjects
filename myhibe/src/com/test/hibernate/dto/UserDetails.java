package com.test.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.ericsson.hibernate.Address;

@Entity
//Enable second level cache
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId= ?")
@NamedNativeQuery(name="UserDetails.byName", query="select * from cruduser where userName= ?", resultClass=UserDetails.class)
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="UserDetails")
public class UserDetails {
	
	/*******************    Tutorial 1 to 11   ********************/
	
	/*@EmbeddedId - To Embed and make Primary Key to a Class object
	Login userId;*/
	//@Column (name="USER_ID")
	/*@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private Integer userId;
	
	//@Column (name="USER_NAME")
	private String userName;
	
	@CollectionOfElements
	@JoinTable(name="User_address", 
	joinColumns=@JoinColumn(name="user_id"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="Address_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList();*/
	//private Set<Address> listOfAddresses = new HashSet<>();

	//@Embedded
	/*@AttributeOverrides ({
		@AttributeOverride (name="street", column=@Column(name="HOME_STREET")),
		@AttributeOverride (name="state", column=@Column(name="HOME_STATE")),
		@AttributeOverride (name="pinCode", column=@Column(name="HOME_PINCODE")),
	@AttributeOverride (name="city", column=@Column(name="HOME_CITY")) })*/
	//private Address homeAddress;
	//@Embedded
	//private Address officeAddress;
	
	/*@Temporal (TemporalType.DATE)
	private Date joinedDate;
	private String address;
	//@Transient
	//@Lob
	private String description;*/
	
	
	/*public String getUserName() {
		return userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}*/
	/*public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/
	
	/*public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}*/
	
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/

	/*public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}*/
	
	/*******************    Tutorial 12   ********************/
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@CollectionOfElements(fetch=FetchType.EAGER)
	private Collection<Address> listOfAddresses = new ArrayList<>();
	
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
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	
/*******************    Tutorial 13 - One to One Mapping   ********************/
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@OneToOne
	@JoinColumn(name="VehicleId")
	private Vehicle vehicle;
	
	
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
/*******************    Tutorial 14 - One to Many Mapping   ********************/
	
	/*@Id
	@GeneratedValue
	private int userId;
	@Column
	private String userName;
	@OneToMany
	@JoinTable(name="UserVehicle", joinColumns=@JoinColumn(name="UserId"), 
		inverseJoinColumns=@JoinColumn(name="VehicleId"))
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
	
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
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}*/
	
/*******************    Tutorial 15 - Mapping   ********************/
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	//@OneToMany(mappedBy="user")
	@ManyToMany
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
	
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
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}*/
	
/*******************    Tutorial 16 - Mapping   ********************/
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
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
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}*/
	
/*******************    Tutorial 21 - CRUD   ********************/
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
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
	}*/
}
