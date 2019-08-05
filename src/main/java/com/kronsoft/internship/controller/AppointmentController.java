package com.kronsoft.internship.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kronsoft.internship.persistence.entity.Appointment;
import com.kronsoft.internship.persistence.repositories.AppointmentRepository;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;

	// Get all appointments
	@GetMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> showAll() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointments;

	}

	// Get a specific appointment based on the id provided
	@GetMapping(value = "/appointment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Appointment getAppointment(@PathVariable("id") Long id) {
		Optional<Appointment> appointmentOpt = this.appointmentRepository.findById(id);
		Appointment appointment = new Appointment();
		if (appointmentOpt.isPresent())
			appointment = appointmentOpt.get();
		return appointment;
	}

	// Create a appointment, it requires a body
	@PostMapping(value = "/appoiment/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return this.appointmentRepository.save(appointment);
	}

	// Delete a patient, it requires a id parameter so we have to
	// provide the id via the link example : appointment/delete?id=3149 (Query
	// parameter)
	@DeleteMapping(value = "/appointment/delete")
	public void deleteAppointment(@RequestParam Long id) {
		if (this.appointmentRepository.existsById(id))
			this.appointmentRepository.deleteById(id);
	}

	// Update a appointment, request a appointment
	@PutMapping(value = "/appointment/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return this.appointmentRepository.save(appointment);
	}
}
