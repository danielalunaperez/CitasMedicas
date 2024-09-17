package com.citas.medicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citas.medicas.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}

