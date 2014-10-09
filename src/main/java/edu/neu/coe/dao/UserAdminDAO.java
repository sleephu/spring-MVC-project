package edu.neu.coe.dao;


import java.util.List;

import edu.neu.coe.domain.User;

public interface UserAdminDAO {
	void create(User user);
	User find(Integer userId);
	void update(User user);
	void delete(Integer userId);	
	List<User> getAllUser();
	
	List<User> getCustomerUser();
	List<User> getRresutaurantUser();
	
	User getUser(String userName);
	
}
