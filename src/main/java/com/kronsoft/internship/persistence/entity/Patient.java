package com.kronsoft.internship.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = "PIN", nullable = false, length = 13)
	private String pin;

	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private PatientSex Sex;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "phone_number")
	private String phoneNumber;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", orphanRemoval = true)
	List<Appoiment> appoiments = new ArrayList<>();

	public List<Appoiment> getAppoiments() {
		return appoiments;
	}

	public void setAppoiments(List<Appoiment> appoiments) {
		this.appoiments = appoiments;
	}

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
		return Sex;
	}

	public void setSex(PatientSex sex) {
		Sex = sex;
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

}
