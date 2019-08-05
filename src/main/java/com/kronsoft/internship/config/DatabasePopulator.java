package com.kronsoft.internship.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kronsoft.internship.persistence.entity.Appointment;
import com.kronsoft.internship.persistence.entity.Patient;
import com.kronsoft.internship.persistence.entity.enums.AppointmentStatus;
import com.kronsoft.internship.persistence.entity.enums.AppointmentType;
import com.kronsoft.internship.persistence.entity.enums.PatientSex;
import com.kronsoft.internship.persistence.repositories.AppointmentRepository;
import com.kronsoft.internship.persistence.repositories.PatientRepository;

@Component
public class DatabasePopulator {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appoimentRepository;

	@PostConstruct
	public void populateDatabase() {
		if(this.patientRepository.count()==0 
				&& this.appoimentRepository.count()== 0)
		for (int i = 0; i < 50; i++) {
			Patient patient = new Patient();
			Date date= new Date(System.currentTimeMillis());
			patient.setBirthDate(date);
			patient.setFirstName("Patient");
			patient.setLastName(""+i);
			patient.setCountry("Romania");
			patient.setCity("Brasov");
			patient.setPhoneNumber("0752541454");
			patient.setSex(PatientSex.UNDEFINED);
			patient.setPin("11111111111"+i);
			Appointment appointment= new Appointment();
			appointment.setPatient(patient);
			appointment.setAppointmentDescription("description");
			appointment.setAppointmentStatus(AppointmentStatus.CREATED);
			appointment.setAppointmentType(AppointmentType.REGULAR);
			this.patientRepository.save(patient);
			this.appoimentRepository.save(appointment);
		}

	}
}
