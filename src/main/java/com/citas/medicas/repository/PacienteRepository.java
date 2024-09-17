package com.citas.medicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citas.medicas.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}

