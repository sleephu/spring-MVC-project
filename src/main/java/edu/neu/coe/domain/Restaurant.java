package edu.neu.coe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESTAURANT_ID")
	private Integer restaurantId;
	@Column(name="RESTAURANT_NAME")
	private String restaurantName;
	@Column(name="TELEPHONENO")
	private String telephone;
    
	@Column(name="Detail")
	private String detail;
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="restaurant", cascade=CascadeType.ALL)
//	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="restaurant",cascade = CascadeType.ALL, orphanRemoval = true)
	private Menu menu;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="restaurant")
	private Set<Address> addresses= new HashSet<Address>();
	
	@OneToOne()
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="restaurant")
	private Set<Appointment> appointments= new HashSet<Appointment>();
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
//	public Set<Menu> getMenus() {
//	return menus;
//}
//
//	public void setMenus(Set<Menu> menus) {
//	this.menus = menus;
//}
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

//	public Address getAddress() {
//	return address;
//}
//
//	public void setAddress(Address address) {
//	this.address = address;
//}

	public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}

	public String getRestaurantName() {
	return restaurantName;
}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephone() {
		return telephone;
	}
	
	
}
