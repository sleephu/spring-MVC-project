package edu.neu.coe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.RoleDAO;
import edu.neu.coe.domain.Role;

@Repository("roleDAO")  
public class RoleDAOImpl implements RoleDAO {  
      
    @Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  
  
    @Override
	public Role getRole(int id) {  
        Role role = (Role)getCurrentSession().load(Role.class, id);  
        return role;  
    }

	@Override
	public void setRole(Role role) {
		
		sessionFactory.getCurrentSession().save(role);
	}  
  
}  

