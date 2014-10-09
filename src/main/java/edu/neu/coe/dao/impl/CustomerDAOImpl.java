package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.CustomerDAO;
import edu.neu.coe.domain.Customer;

@Repository  
public class CustomerDAOImpl implements CustomerDAO {  
      
    @Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  

	@Override
	public void create(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public Customer find(Integer customerId) {
		   Customer customer = (Customer) getCurrentSession().load(Customer.class, customerId);  
	        return customer;  
	}

	@Override
	public void update(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public void delete(Integer customerId) {
		   Customer customer = (Customer) getCurrentSession().load(Customer.class, customerId);  
        if (null != customer) {
        	try {
        		sessionFactory.getCurrentSession().delete(customer);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}
//		sessionFactory.getCurrentSession().delete(find(customerId));
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomer() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}  
  
}  

