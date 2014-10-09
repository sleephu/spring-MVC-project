package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Food;

public interface FoodService {

	void create(Food food);
	Food find(Integer id);
	void update(Food food);

	void delete(Integer id);
	List<Food> listFood();
	
}
