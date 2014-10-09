package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Appointment;

public interface AppointmentService {

	void create(Appointment appointment);
	Appointment find(Integer id);
	void update(Appointment appointment);

	void delete(Integer id);
	List<Appointment> listAppointment();
}
