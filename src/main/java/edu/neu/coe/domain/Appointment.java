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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="APPOINTMENT_ID", unique=true, nullable=false)
	private Integer appointmentId;
	@Column(name="APPOINTMENT_START_TIME")
	private String startTime;
	@Column(name="APPOINTMENT_END_TIME")
	private String endTime;
	@Column(name="CREATE_TIME")
	private String createTime;
	@Column(name="DETAIL")
	private String detail;
//	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="appointment")
//	@JoinColumn(name="Order_ID")
//	private  Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="appointment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderedFood> orderedFoods= new HashSet<OrderedFood>();
	
	public Set<OrderedFood> getOrderedFoods() {
		return orderedFoods;
	}
	public void setOrderedFoods(Set<OrderedFood> orderedFoods) {
		this.orderedFoods = orderedFoods;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		
		this.startTime = startTime;
	}
//	public Timestamp getEndTime() {
//		return endTime;
//	}
//	public void setEndTime(Timestamp endTime) {
//		this.endTime = endTime;
//	}
//	
//	public void setStartTime(Timestamp startTime) {
//		this.startTime = startTime;
//	}
//	
//	public Timestamp getStartTime() {
//		return startTime;
//	}
	
//	public Timestamp getAppointmentTime() {
//		return appointmentTime;
//	}
//	public void setAppointmentTime(Timestamp appointmentTime) {
//		this.appointmentTime = appointmentTime;
//	}
//	public Timestamp getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(Timestamp createTime) {
//		this.createTime = createTime;
//	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Integer getAppointmentId() {
		return appointmentId;
	}
 
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}
//	public Set<Order> getOrders() {
//		return orders;
//	}
//	public Integer getPersonNum() {
//		return personNum;
//	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//	public void setPersonNum(Integer personNum) {
//		this.personNum = personNum;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
