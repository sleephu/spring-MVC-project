package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.Address;

public interface AddressDAO {

	void create(Address address);
	Address find(Integer id);
	void update(Address address);

	void delete(Integer id);
	List<Address> listAddress();
}
