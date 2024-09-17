package com.citas.medicas.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Consultorio {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private int numeroConsultorio;
	    private int piso;

	    // Relación con citas
	    @OneToMany(mappedBy = "consultorio")
	    private List<Cita> citas;

		public int getNumeroConsultorio() {
			return numeroConsultorio;
		}

		public void setNumeroConsultorio(int numeroConsultorio) {
			this.numeroConsultorio = numeroConsultorio;
		}

		public int getPiso() {
			return piso;
		}

		public void setPiso(int piso) {
			this.piso = piso;
		}
}
