package edu.neu.coe.domain;

import java.util.ArrayList;
import java.util.List;
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
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MENU_ID", unique=true, nullable=false)
	private Integer menuId;
	
	@Column(name="MENU_NAME")
	private String menuName;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="menu", cascade=CascadeType.ALL)
	private List<Food> foods = new ArrayList<Food>();
	
	
	@OneToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
public String getMenuName() {
	return menuName;
}
public void setMenuName(String menuName) {
	this.menuName = menuName;
}
//	public void setFoods(Set<Food> foods) {
//		this.foods = foods;
//	}
//	public Set<Food> getFoods() {
//		return foods;
//	}

public List<Food> getFoods() {
	return foods;
}
public void setFoods(List<Food> foods) {
	this.foods = foods;
}
}
