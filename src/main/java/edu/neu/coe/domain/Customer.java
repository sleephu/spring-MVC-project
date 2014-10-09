package edu.neu.coe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Check;

@Entity
@Table(name="customer", uniqueConstraints=@UniqueConstraint(columnNames={"FIRST_NAME", "LAST_NAME","GENDER","TELEPHONENO"
		,"EMAIL"}))
public class Customer {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
    private String lastName;
	@Column(name="GENDER")
	@Check(constraints = "GENDER IN ('M','F')")
    private String gender;
	@Column(name="TELEPHONENO")
    private String telephoneNo;
	@Column(name="EMAIL")
    private String email;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
//	private Set<Address> addresses= new HashSet<Address>();
    
	
	@OneToOne()
	@JoinColumn(name="USER_ID")
    private User user;
    
//    @OneToOne(fetch=FetchType.LAZY, mappedBy="person", cascade=CascadeType.ALL)
//    private Customer customer;
//    
//    @OneToOne(fetch=FetchType.LAZY, mappedBy="person", cascade=CascadeType.ALL)
//    private Restaurant restaurant;
//    
//    public Customer getCustomer() {
//		return customer;
//	}
//    public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//    public Restaurant getRestaurant() {
//		return restaurant;
//	}
//    public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
//    public void setAddresses(Set<Address> addresses) {
//		this.addresses = addresses;
//	}
//	public Set<Address> getAddresses() {
//		return addresses;
//	}
    public void setGender(String gender) {
		this.gender = gender;
	}
    public String getGender() {
		return gender;
	}
    public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
    public Integer getCustomerId() {
		return customerId;
	}

//    public Integer getUserId() {
//		return userId;
//	}
//    public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
 public void setUser(User user) {
	this.user = user;
}
 public User getUser() {
	return user;
}
    
    public void setEmail(String email) {
		this.email = email;
	}
    public String getEmail() {
		return email;
	}
    public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
    public String getTelephoneNo() {
		return telephoneNo;
	}
    public String getFirstName() {
		return firstName;
	}
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    public String getLastName() {
		return lastName;
	}
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
