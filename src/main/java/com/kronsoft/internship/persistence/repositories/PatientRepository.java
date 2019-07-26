package com.kronsoft.internship.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kronsoft.internship.persistence.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
