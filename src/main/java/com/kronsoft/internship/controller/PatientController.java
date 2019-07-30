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

import com.kronsoft.internship.persistence.entity.Patient;
import com.kronsoft.internship.persistence.repositories.AppoimentRepository;
import com.kronsoft.internship.persistence.repositories.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;


	// Gel all patients from DB
	@GetMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> showAll() {
		List<Patient> patients = patientRepository.findAll();
		return patients;

	}

	// Get a specific patient based on his id
	@GetMapping(value = "/patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient getClient(@PathVariable("id") Long id) {
		Optional<Patient> patientOpt = patientRepository.findById(id);
		Patient patient = new Patient();
		if (patientOpt.isPresent())
			patient = patientOpt.get();
		return patient;
	}

	// Create a patient, it requires a body
	@PostMapping(value = "/patient/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient createPatient(@RequestBody Patient patient) {
		return this.patientRepository.save(patient);
	}

	// Delete a patient, it requires a id parameter so we have to
	// provide the id via the link example : patient/delete?id=3149 (Query parameter)
	@DeleteMapping(value = "/patient/delete")
	public void deleteClient(@RequestParam Long id) {
		if (this.patientRepository.existsById(id))
			this.patientRepository.deleteById(id);
	}
	
	@PutMapping(value = "/patient/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient updatePatient(@RequestBody Patient patient) {
		return this.patientRepository.save(patient);
	}

}
