package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.AddressDAO;
import edu.neu.coe.domain.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
    	 return sessionFactory.getCurrentSession();  
    }  

    
	@Override
	public void create(Address address) {
		sessionFactory.getCurrentSession().save(address);
		
	}


	@Override
	public Address find(Integer id) {
		return (Address) getCurrentSession().load(Address.class, id);
	}

	
	@Override
	public void update(Address address) {
		sessionFactory.getCurrentSession().update(address);
		
	}


	@Override
	public void delete(Integer id) {
		sessionFactory.getCurrentSession().delete(find(id));;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listAddress() {
		return sessionFactory.getCurrentSession().createQuery("from Address").list();
	}

}
