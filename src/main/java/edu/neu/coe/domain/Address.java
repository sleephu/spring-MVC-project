package edu.neu.coe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID", unique=true, nullable=false)
	private Integer addressId;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="STREET")
	private String street;
	@Column(name="ZIPCODE")
	private String zipCode;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="CUSTOMER_ID")
//	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
//	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="USER_ID",nullable=false)
//	private Restaurant restaurant;
	
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
//	public void setPerson(Customer person) {
//		this.person = person;
//	}
//	public Customer getPerson() {
//		return person;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Customer getCustomer() {
//		return customer;
//	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
