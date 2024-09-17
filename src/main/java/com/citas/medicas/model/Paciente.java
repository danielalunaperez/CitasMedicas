package com.citas.medicas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Paciente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incrementar ID
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;

    @Column(unique = true)  // El email debe ser único
    private String email;

    // Constructor vacío (requerido por JPA)
    public Paciente() {}

    // Constructor con todos los parámetros
    public Paciente(String nombre, String apellido, String telefono, String email) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.email = email;
}
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Getter @Setter
    private String direccion;
    
}
