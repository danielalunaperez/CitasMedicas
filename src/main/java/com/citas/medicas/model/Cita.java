package com.citas.medicas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cita {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne  // Una cita está asociada a un paciente
	    private Paciente paciente;

	    @ManyToOne  // Una cita está asociada a un doctor
	    private Doctor doctor;
	    
	    @ManyToOne
	    private Consultorio consultorio;
	    
	    private LocalDateTime fecha;  // Fecha y hora de la cita

	    private String motivo;  // Descripción del motivo de la cita

	    public Cita() {}

	    public Cita(Paciente paciente, Doctor doctor, LocalDateTime fecha, String motivo) {
	        this.paciente = paciente;
	        this.doctor = doctor;
	        this.setFecha(fecha);
	        this.setMotivo(motivo);
	    }

		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		public String getMotivo() {
			return motivo;
		}

		public void setMotivo(String motivo) {
			this.motivo = motivo;
		}

		public Object getConsultorio() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getHorarioConsulta() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getDoctor() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getNombrePaciente() {
			// TODO Auto-generated method stub
			return null;
		}
}
