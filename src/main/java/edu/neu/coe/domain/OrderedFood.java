package edu.neu.coe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderedFood")
public class OrderedFood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDERED_FOOD_ID", unique=true, nullable=false)
	private Integer foodId;

	@Column(name="FOOD_QUANTITY")
	private Integer num;
	
	@OneToOne
	@JoinColumn(name="FOOD_ID")
	private Food food;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="APPOINTMENT_ID")
	private Appointment appointment;
	
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
