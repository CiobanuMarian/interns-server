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

import com.kronsoft.internship.persistence.entity.Appoiment;
import com.kronsoft.internship.persistence.entity.Patient;
import com.kronsoft.internship.persistence.repositories.AppoimentRepository;

@RestController
public class AppoimentController {
	
	
	@Autowired
	private AppoimentRepository appoimentRepository;
	
	
	@GetMapping(value = "/appoiments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appoiment> showAll() {
		List<Appoiment> appoiments = appoimentRepository.findAll();
		return appoiments;

	}
	
	
	@GetMapping(value = "/appoiment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Appoiment getAppoiment(@PathVariable("id") Long id) {
		Optional<Appoiment> appoimentOpt = this.appoimentRepository.findById(id);
		Appoiment appoiment = new Appoiment();
		if (appoimentOpt.isPresent())
			appoiment = appoimentOpt.get();
		return appoiment;
	}
	
	
	//Function to get the appoiments from a specific patient
//	@GetMapping(value="/appoiment/patientAppoiments", produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//	public List<Appoiment> showPatientAppoiments(@RequestBody Patient patient)
//	{
//		List<Appoiment> appoiments=this.appoimentRepository.findByPatient(patient);
//		return appoiments;
//	}

	// Create a appoiment, it requires a body
	@PostMapping(value = "/appoiment/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Appoiment createAppoiment(@RequestBody Appoiment appoiment) {
		return this.appoimentRepository.save(appoiment);
	}

	// Delete a patient, it requires a id parameter so we have to
	// provide the id via the link example : appoiment/delete?id=3149 (Query parameter)
	@DeleteMapping(value = "/appoiment/delete")
	public void deleteAppoiment(@RequestParam Long id) {
		if (this.appoimentRepository.existsById(id))
			this.appoimentRepository.deleteById(id);
	}
	
	@PutMapping(value = "/appoiment/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Appoiment updateAppoiment(@RequestBody Appoiment appoiment) {
		return this.appoimentRepository.save(appoiment);
	}
}
