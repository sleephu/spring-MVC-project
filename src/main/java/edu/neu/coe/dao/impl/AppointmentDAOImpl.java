package edu.neu.coe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.dao.AppointmentDAO;
import edu.neu.coe.domain.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	
	@Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
    	 return sessionFactory.getCurrentSession();  
    }  
    
	
	@Override
	public void create(Appointment appointment) {
		sessionFactory.getCurrentSession().save(appointment);

	}


	@Override
	public Appointment find(Integer id) {
		Appointment appointment= (Appointment)sessionFactory.getCurrentSession().load(Appointment.class, id);
		return appointment;
	}


	@Override
	public void update(Appointment appointment) {
		sessionFactory.getCurrentSession().update(appointment);
	}


	@Override
	public void delete(Integer id) {
		  Appointment a = (Appointment) getCurrentSession().load(Appointment.class, id); 
		  System.out.println("in delete Dao");
	        if (null != a) {
	        	try {
	        		sessionFactory.getCurrentSession().delete(a);
	        		sessionFactory.getCurrentSession().flush();
	        	} catch (HibernateException e) {
	        		e.printStackTrace();
	        	}
	        }
		

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAppointment() {
		return getCurrentSession().createQuery("from Appointment").list();
	}

}
