package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.OrderedFood;

public interface OrderedFoodDAO {

	void create(OrderedFood food);
	OrderedFood find(Integer id);
	void update(OrderedFood food);

	void delete(Integer id);
	List<OrderedFood> listFood();
}
