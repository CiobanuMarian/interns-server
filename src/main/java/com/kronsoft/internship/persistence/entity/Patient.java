package com.kronsoft.internship.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kronsoft.internship.persistence.entity.enums.PatientSex;

@Entity
@Table(name = "patients")
public class Patient {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "patient_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "patient_first_name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "patient_last_name", nullable = false, length = 100)
	private String lastName;

	@Column(name = "birth_date",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = "PIN", nullable = false, length = 13,unique=true)
	private String pin;

	@Column(name = "sex",nullable=false)
	@Enumerated(EnumType.STRING)
	private PatientSex sex;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "phone_number",nullable=false)
	private String phoneNumber;

	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "patient", orphanRemoval = true)
	private List<Appointment> appoiments=new ArrayList<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public PatientSex getSex() {
		return sex;
	}

	public void setSex(PatientSex sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Appointment> getAppoiments() {
		return appoiments;
	}

	public void setAppoiments(List<Appointment> appoiments) {
		this.appoiments = appoiments;
	}

}
