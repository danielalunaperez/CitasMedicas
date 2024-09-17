package com.citas.medicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.citas.medicas.model.Doctor;
import com.citas.medicas.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Obtener todos los doctores
    @GetMapping
    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorService.obtenerTodosLosDoctores();
    }

    // Obtener un doctor por ID
    @GetMapping("/{id}")
    public Doctor obtenerDoctorPorId(@PathVariable Long id) {
        return doctorService.obtenerDoctorPorId(id);
    }

    // Crear un nuevo doctor
    @PostMapping
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
        return doctorService.guardarDoctor(doctor);
    }

    // Actualizar un doctor
    @PutMapping("/{id}")
    public Doctor actualizarDoctor(@PathVariable Long id, @RequestBody Doctor doctorActualizado) {
        return doctorService.actualizarDoctor(id, doctorActualizado);
    }

    // Eliminar un doctor
    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable Long id) {
        doctorService.eliminarDoctor(id);
    }
}

