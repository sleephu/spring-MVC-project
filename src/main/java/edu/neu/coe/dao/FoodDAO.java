package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.Food;

public interface FoodDAO {

	void create(Food food);
	Food find(Integer id);
	void update(Food food);

	void delete(Integer id);
	List<Food> listFood();
	
//	List<Food>menuFood();
//	List<Food>orderFood();
	
}
