package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Restaurant;

public interface RestaurantService {
	void create(Restaurant restaurant);
	Restaurant find(Integer restaurantId);
	void update(Restaurant restaurant);

	void delete(Integer restaurantId);
	List<Restaurant> ListRestaurants();
	
	Restaurant getRestaurant(String restaurantName);
}
