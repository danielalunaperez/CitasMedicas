package com.citas.medicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.citas.medicas.model.Cita;
import com.citas.medicas.service.CitaService;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Obtener las citas de un doctor en particular
    @GetMapping("/doctor/{doctorId}")
    public List<Cita> obtenerCitasPorDoctor(@PathVariable Long doctorId) {
        return citaService.obtenerCitasPorDoctorId(doctorId);
    }

    // Obtener las citas de un paciente en particular
    @GetMapping("/paciente/{pacienteId}")
    public List<Cita> obtenerCitasPorPaciente(@PathVariable Long pacienteId) {
        return citaService.obtenerCitasPorPacienteId(pacienteId);
    }

    // Crear una nueva cita
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaService.guardarCita(cita);
    }

    // Eliminar una cita
    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }
}

