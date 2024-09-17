package com.citas.medicas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citas.medicas.model.Cita;
import com.citas.medicas.model.Doctor;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDoctorId(Long doctorId);  // Método para encontrar citas por doctor
        boolean existsByConsultorioAndHorarioConsulta(Object object, Object object2);
        boolean existsByDoctorAndHorarioConsulta(Object object, Object object2);
        boolean existsByNombrePacienteAndHorarioConsultaBetween(String nombrePaciente, LocalDateTime inicio, LocalDateTime fin);
        long countByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime inicio, LocalDateTime fin);

}

