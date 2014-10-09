package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.UserAdminDAO;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.UserAdminService;

@Service("userAdminService")
public class UserAdminServiceImpl implements UserAdminService {

	@Autowired
	private UserAdminDAO userAdminDAO;

	@Override
	@Transactional
	public void create(User user) {
		userAdminDAO.create(user);
	}

	@Override
	@Transactional
	public User find(Integer userId) {
		return userAdminDAO.find(userId);
	}

	@Override
	@Transactional
	public void update(User user) {
		userAdminDAO.update(user);
		
	}

	@Override
	@Transactional
	public void delete(Integer userId) {
		userAdminDAO.delete(userId);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		return userAdminDAO.getAllUser();
	}

	@Override
	public User getUser(String userName) {
		return userAdminDAO.getUser(userName);
	}

}
