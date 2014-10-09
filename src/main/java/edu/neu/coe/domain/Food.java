package edu.neu.coe.domain;

import javax.persistence.CascadeType;
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
@Table(name="food")
public class Food {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FOOD_ID", unique=true, nullable=false)
	private Integer foodId;
	@Column(name="FOOD_NAME",length=50)
	private String foodName;
	@Column(name="FOOD_PRICE")
	private double price;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="MENU_ID")
	private Menu menu;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
	private OrderedFood orderFood;
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
//	public Set<Menu> getMenus() {
//		return menus;
//	}
//	public void setMenus(Set<Menu> menus) {
//		this.menus = menus;
//	}
	public OrderedFood getOrderFood() {
		return orderFood;
	}
	public void setOrderFood(OrderedFood orderFood) {
		this.orderFood = orderFood;
	}
//	public Menu getMenu() {
//		return menu;
//	}
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
