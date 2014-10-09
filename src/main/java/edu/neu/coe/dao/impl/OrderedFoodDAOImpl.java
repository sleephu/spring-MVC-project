package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.OrderedFoodDAO;
import edu.neu.coe.domain.OrderedFood;
@Repository
public class OrderedFoodDAOImpl implements OrderedFoodDAO {

	@Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  
    
	@Override
	public void create(OrderedFood food) {
		getCurrentSession().save(food);

	}

	@Override
	public OrderedFood find(Integer id) {
		OrderedFood food = (OrderedFood) getCurrentSession().load(OrderedFood.class, id);  
	        return food;  
	}


	@Override
	public void update(OrderedFood food) {
		sessionFactory.getCurrentSession().update(food);

	}

	
	@Override
	public void delete(Integer id) {
		 OrderedFood o = (OrderedFood) getCurrentSession().load(OrderedFood.class, id); 
		  System.out.println("orderedFooo!!!!in delete Dao");
	        if (null != o) {
	        	try {
	        		sessionFactory.getCurrentSession().delete(o);
	        		sessionFactory.getCurrentSession().flush();
	        	} catch (HibernateException e) {
	        		e.printStackTrace();
	        	}
	        }

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderedFood> listFood() {
		return sessionFactory.getCurrentSession().createQuery("from OrderedFood").list();
	}


}
