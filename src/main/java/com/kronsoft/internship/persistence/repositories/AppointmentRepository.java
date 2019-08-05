package com.kronsoft.internship.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kronsoft.internship.persistence.entity.Appointment;
import com.kronsoft.internship.persistence.entity.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByPatient(Patient patient);
}
