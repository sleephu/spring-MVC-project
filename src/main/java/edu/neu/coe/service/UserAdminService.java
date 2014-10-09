package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.User;



public interface UserAdminService {


//	User signup(String userName, String password);
//	
//	User login(String userName, String password);
//	
//	ArrayList<User> allUser();
	void create(User user);
	User find(Integer userId);
	void update(User user);
	void delete(Integer userId);	
	List<User> getAllUser();
	
	User getUser(String userName);
}
