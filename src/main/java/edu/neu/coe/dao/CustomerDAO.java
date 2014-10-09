package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.Customer;

public interface CustomerDAO {

	void create(Customer customer);
	Customer find(Integer customerId);
	void update(Customer customer);

	void delete(Integer customerId);
	List<Customer> listCustomer();
}
