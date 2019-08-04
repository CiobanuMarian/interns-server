package com.kronsoft.internship.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kronsoft.internship.persistence.entity.Appoiment;
import com.kronsoft.internship.persistence.entity.Patient;

public interface AppoimentRepository extends JpaRepository<Appoiment, Long> {
	List<Appoiment> findByPatient(Patient patient);
}
