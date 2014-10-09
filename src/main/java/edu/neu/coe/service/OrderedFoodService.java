package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.OrderedFood;

public interface OrderedFoodService {
	void create(OrderedFood food);
	OrderedFood find(Integer id);
	void update(OrderedFood food);

	void delete(Integer id);
	List<OrderedFood> listFood();
}
