package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.AppointmentDAO;
import edu.neu.coe.domain.Appointment;
import edu.neu.coe.service.AppointmentService;


@Service  
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	 @Autowired  
	 private AppointmentDAO appointmentDAO;     
	
	 
	@Override
	@Transactional  
	public void create(Appointment appointment) {
		appointmentDAO.create(appointment);
		
	}

	
	@Override
	@Transactional  
	public Appointment find(Integer id) {
		return appointmentDAO.find(id);
	}


	@Override
	@Transactional  
	public void update(Appointment appointment) {
		appointmentDAO.update(appointment);
		
	}


	@Override
	@Transactional  
	public void delete(Integer id) {
		appointmentDAO.delete(id);
		
	}

	
	@Override
	@Transactional  
	public List<Appointment> listAppointment() {
	return appointmentDAO.listAppointment();
	}

	
}
