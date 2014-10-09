package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Address;

public interface AddressService {

	void create(Address address);
	Address find(Integer id);
	void update(Address address);

	void delete(Integer id);
	List<Address> listAddress();
}
