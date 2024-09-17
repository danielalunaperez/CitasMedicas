package com.citas.medicas.service;
import com.citas.medicas.model.Doctor;
import com.citas.medicas.model.Cita;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citas.medicas.repository.CitaRepository;
@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public Cita agendarCita(Cita cita) {

    	// Regla 1: Consultorio no puede tener una cita a la misma hora
        if (citaRepository.existsByConsultorioAndHorarioConsulta(cita.getConsultorio(), cita.getHorarioConsulta())) {
            throw new IllegalArgumentException("Ya hay una cita programada en este consultorio a esa hora.");
        }

        // Regla 2: Doctor no puede tener una cita a la misma hora
        if (citaRepository.existsByDoctorAndHorarioConsulta(cita.getDoctor(), cita.getHorarioConsulta())) {
            throw new IllegalArgumentException("El doctor ya tiene una cita programada a esa hora.");
        }

        // Regla 3: Paciente no puede tener otra cita en menos de 2 horas
        LocalDateTime inicioVentana = ((LocalDateTime) cita.getHorarioConsulta()).minusHours(2);
        LocalDateTime finVentana = ((LocalDateTime) cita.getHorarioConsulta()).plusHours(2);
        if (citaRepository.existsByNombrePacienteAndHorarioConsultaBetween((String) cita.getNombrePaciente(), inicioVentana, finVentana)) {
            throw new IllegalArgumentException("El paciente ya tiene una cita cercana en el mismo día.");
        }

        // Regla 4: Doctor no puede tener más de 8 citas en el mismo día
        LocalDate diaCita = ((LocalDateTime) cita.getHorarioConsulta()).toLocalDate();
        if (citaRepository.countByDoctorAndHorarioConsultaBetween((Doctor) cita.getDoctor(), diaCita.atStartOfDay(), diaCita.plusDays(1).atStartOfDay()) >= 8) {
            throw new IllegalArgumentException("El doctor ya tiene 8 citas programadas para este día.");
        }

        return citaRepository.save(cita);
    }
   
   

    public List<Cita> obtenerCitasPorDoctor(Long doctorId) {
        // Lógica para obtener citas por doctor
        return citaRepository.findByDoctorId(doctorId);
    }

    public Optional<Cita> obtenerCitaPorId(Long id) {
        return citaRepository.findById(id);
    }

    public void cancelarCita(Long id) {
        citaRepository.deleteById(id);
    }



	public List<Cita> obtenerCitasPorDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cita> obtenerCitasPorPacienteId(Long pacienteId) {
		// TODO Auto-generated method stub
		return null;
	}


	public Cita guardarCita(Cita cita) {
		// TODO Auto-generated method stub
		return null;
	}


	public void eliminarCita(Long id) {
		// TODO Auto-generated method stub
		
	}
    
}

