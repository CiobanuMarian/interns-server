package com.kronsoft.internship.persistence.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kronsoft.internship.persistence.entity.enums.AppoimentStatus;
import com.kronsoft.internship.persistence.entity.enums.AppoimentType;

@Entity
@Table(name = "appoiments")
public class Appoiment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "appoiment_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="appoiment_type")
	@Enumerated(EnumType.STRING)
	private AppoimentType appoimentType;
	
	@Column(name="appoiment_status")
	@Enumerated(EnumType.STRING)
	private AppoimentStatus appoimentStatus;
	
	
	@Column(name="start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column(name="end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column(name="appoiment_description")
	private String appoimentDescription;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppoimentType getAppoimentType() {
		return appoimentType;
	}

	public void setAppoimentType(AppoimentType appoimentType) {
		this.appoimentType = appoimentType;
	}

	public AppoimentStatus getAppoimentStatus() {
		return appoimentStatus;
	}

	public void setAppoimentStatus(AppoimentStatus appoimentStatus) {
		this.appoimentStatus = appoimentStatus;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAppoimentDescription() {
		return appoimentDescription;
	}

	public void setAppoimentDescription(String appoimentDescription) {
		this.appoimentDescription = appoimentDescription;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
