package edu.neu.coe.service;

import edu.neu.coe.domain.User;

public interface UserService {

	 public User getUser(String userName); 
	 
	 User signup(String userName, String password);
}
