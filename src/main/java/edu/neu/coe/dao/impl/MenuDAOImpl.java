package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.MenuDAO;
import edu.neu.coe.domain.Menu;


@Repository
public class MenuDAOImpl implements MenuDAO {

	@Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
    	 return sessionFactory.getCurrentSession();  
    }  
    
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> listMenu() {
		return getCurrentSession().createQuery("from Menu").list();
	}



	@Override
	public void createMenu(Menu menu) {
		sessionFactory.getCurrentSession().save(menu);
		
	}



	@Override
	public void updateMenu(Menu menu) {
	   sessionFactory.getCurrentSession().update(menu);
	}



	@Override
	public Menu getMenu(Integer id) {
	 return (Menu)sessionFactory.getCurrentSession().load(Menu.class, id);
	}



	@Override
	public void deleteMenu(Integer id) {
		sessionFactory.getCurrentSession().delete(getMenu(id));
		
	}

}
