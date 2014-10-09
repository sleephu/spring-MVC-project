package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.CustomerDAO;
import edu.neu.coe.domain.Customer;
import edu.neu.coe.service.CustomerService;

@Service  
@Transactional
public class CustomerServiceImpl implements CustomerService {

	 @Autowired  
	 private CustomerDAO customerDAO;     
	
	
	@Override
	@Transactional  
	public void create(Customer customer) {
	     customerDAO.create(customer);

	}

	
	@Override
	@Transactional  
	public Customer find(Integer customerId) {
		return customerDAO.find(customerId);
	}

	
	@Override
	@Transactional  
	public void update(Customer customer) {
		customerDAO.update(customer);
	}

	
	@Override
	@Transactional  
	public void delete(Integer customerId) {
	    customerDAO.delete(customerId);

	}

	
	@Override
	@Transactional  
	public List<Customer> listCustomer() {
		return customerDAO.listCustomer();
	}

}
