package edu.neu.coe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.UserAdminDAO;
import edu.neu.coe.domain.User;

@Repository("userAdminRole")
public class UserAdminHibernateDAOImpl implements UserAdminDAO {

	 @Autowired
	 private SessionFactory sessionFactory;


	 @Override
	public void create(User user) {
	sessionFactory.getCurrentSession().save(user);

	
}

	  @Override
	public User find(Integer userId) {
     return (User)sessionFactory.getCurrentSession().get(User.class, userId);
}

	
	  @Override
	public void update(User user) {
	sessionFactory.getCurrentSession().update(user);
	
}

	
	  @Override
	public void delete(Integer userId) {
	   sessionFactory.getCurrentSession().delete(find(userId));
	
}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
	return sessionFactory.getCurrentSession().createQuery("from User").list();
}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> getCustomerUser() {
		return sessionFactory.getCurrentSession().createQuery("from User as u WHERE u.role.roleId =2").list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getRresutaurantUser() {
		return sessionFactory.getCurrentSession().createQuery(
				"from User as u WHERE u.role.roleId =3"
				).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userName) {
		List<User> userList = new ArrayList<User>();  
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
//        		+ "`bookingRestaurant`.`user`"
        		+ "User "
        		+ "WHERE userName=:userName");  
        query.setParameter("userName", userName);  
        userList = query.list();  
        if (userList.size() > 0)  
            return userList.get(0);  
        else  {
        	
        	 System.out.println("USER NOT FOUND : userName:"+userName);
            return null;      
       
        }
	}

	    	
	  

}
