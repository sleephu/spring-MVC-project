package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.FoodDAO;
import edu.neu.coe.domain.Food;

@Repository
public class FoodDAOImpl implements FoodDAO {

	@Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  
    
	@Override
	public void create(Food food) {
		sessionFactory.getCurrentSession().save(food);
	}

	
	@Override
	public Food find(Integer id) {
		 Food food = (Food) getCurrentSession().load(Food.class, id);  
	        return food;  
	}


	@Override
	public void update(Food food) {
		sessionFactory.getCurrentSession().update(food);

	}

	
	@Override
	public void delete(Integer id) {
		sessionFactory.getCurrentSession().delete(find(id));

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> listFood() {
		return sessionFactory.getCurrentSession().createQuery("from Food").list();
	}

//	@Override
//	public List<Food> menuFood() {
//		return sessionFactory.getCurrentSession().createQuery("from food").list();
//	}
//
//	@Override
//	public List<Food> orderFood() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
