package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.AddressDAO;
import edu.neu.coe.domain.Address;
import edu.neu.coe.service.AddressService;

@Service  
@Transactional
public class AddressServiceImpl implements AddressService {


	 @Autowired  
	 private AddressDAO addressDAO; 
	 
	@Override
	@Transactional  
	public void create(Address address) {
		addressDAO.create(address);

	}


	@Override
	@Transactional  
	public Address find(Integer id) {
	return	addressDAO.find(id);
	}


	@Override
	@Transactional  
	public void update(Address address) {
		addressDAO.update(address);

	}

	@Override
	@Transactional  
	public void delete(Integer id) {
		addressDAO.delete(id);

	}


	@Override
	@Transactional  
	public List<Address> listAddress() {
		return addressDAO.listAddress();
	}

}
