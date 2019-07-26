package com.kronsoft.internship.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kronsoft.internship.persistence.entity.Appoiment;

public interface AppoimentRepository extends JpaRepository<Appoiment, Long> {

}
