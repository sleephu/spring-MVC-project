package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Customer;

public interface CustomerService {
	
	void create(Customer customer);
	Customer find(Integer customerId);
	void update(Customer customer);

	void delete(Integer customerId);
	List<Customer> listCustomer();
}
