package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.RestaurantDAO;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.service.RestaurantService;

@Service  
@Transactional  
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;  

	@Override
	@Transactional  
	public void create(Restaurant restaurant) {
		restaurantDAO.create(restaurant);

	}

	
	@Override
	@Transactional  
	public Restaurant find(Integer restaurantId) {
             return restaurantDAO.find(restaurantId);
	}

	@Override
	@Transactional  
	public void update(Restaurant restaurant) {
		restaurantDAO.update(restaurant);
	}

	
	@Override
	@Transactional  
	public void delete(Integer restaurantId) {
		restaurantDAO.delete(restaurantId);
	}

	@Override
	@Transactional  
	public List<Restaurant> ListRestaurants() {
		return restaurantDAO.ListRestaurants();
	}


	@Override
	@Transactional  
	public Restaurant getRestaurant(String restaurantName) {
		return restaurantDAO.getRestaurant(restaurantName);
	}

}
