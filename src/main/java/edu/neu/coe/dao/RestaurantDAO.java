package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.Restaurant;

public interface RestaurantDAO {
	void create(Restaurant restaurant);
	Restaurant find(Integer restaurantId);
	void update(Restaurant restaurant);

	void delete(Integer restaurantId);
	List<Restaurant> ListRestaurants();
	Restaurant getRestaurant(String restaurantName);
	
}
