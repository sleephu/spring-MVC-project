package edu.neu.coe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.RestaurantDAO;
import edu.neu.coe.domain.Restaurant;

@Repository  
public class RestaurantDAOImpl implements RestaurantDAO {  
      
    @Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  

	@Override
	public void create(Restaurant restaurant) {
		sessionFactory.getCurrentSession().save(restaurant);
	}


	@Override
	public Restaurant find(Integer id) {
		   Restaurant restaurant = (Restaurant) getCurrentSession().load(Restaurant.class, id);  
	        return restaurant;  
	}


	@Override
	public void update(Restaurant restaurant) {
		sessionFactory.getCurrentSession().update(restaurant);
	}


	@Override
	public void delete(Integer id) {
		sessionFactory.getCurrentSession().delete(find(id));
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> ListRestaurants() {
		return getCurrentSession().createQuery("from Restaurant").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Restaurant getRestaurant(String restaurantName) {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();  
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
//        		+ "`bookingRestaurant`.`user`"
        		+ "Restaurant "
        		+ "WHERE restaurantName=:restaurantName");  
        query.setParameter("restaurantName", restaurantName);  
        restaurants = query.list();  
        if (restaurants.size() > 0)  
            return restaurants.get(0);  
        else  {
        	
        	 System.out.println("USER NOT FOUND : restaurantName:"+restaurantName);
            return null;      
       
        }
	}
  
}  

