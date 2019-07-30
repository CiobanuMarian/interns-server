package com.kronsoft.internship.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kronsoft.internship.persistence.entity.Appoiment;
import com.kronsoft.internship.persistence.entity.Patient;
import com.kronsoft.internship.persistence.entity.enums.AppoimentStatus;
import com.kronsoft.internship.persistence.entity.enums.AppoimentType;
import com.kronsoft.internship.persistence.entity.enums.PatientSex;
import com.kronsoft.internship.persistence.repositories.AppoimentRepository;
import com.kronsoft.internship.persistence.repositories.PatientRepository;

@Component
public class DatabasePopulator {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppoimentRepository appoimentRepository;

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
			patient.setPhoneNumber("0123456");
			patient.setSex(PatientSex.UNDEFINED);
			patient.setPin("11111111111"+i);
			Appoiment appoiment= new Appoiment();
			appoiment.setPatient(patient);
			appoiment.setAppoimentDescription("description");
			appoiment.setAppoimentStatus(AppoimentStatus.CREATED);
			appoiment.setAppoimentType(AppoimentType.REGULAR);
			this.patientRepository.save(patient);
			this.appoimentRepository.save(appoiment);
		}

	}
}
