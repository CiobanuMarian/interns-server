package com.kronsoft.internship.persistence.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kronsoft.internship.persistence.entity.enums.AppointmentStatus;
import com.kronsoft.internship.persistence.entity.enums.AppointmentType;

@Entity
@Table(name = "appointments")
public class Appointment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "appointment_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="appointment_type")
	@Enumerated(EnumType.STRING)
	private AppointmentType appointmentType;
	
	@Column(name="appointment_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;
	
	
	@Column(name="start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column(name="end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column(name="appointment_description")
	private String appointmentDescription;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
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

	public String getAppointmentDescription() {
		return appointmentDescription;
	}

	public void setAppointmentDescription(String appointmentDescription) {
		this.appointmentDescription = appointmentDescription;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}