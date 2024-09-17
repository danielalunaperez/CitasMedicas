package com.citas.medicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.citas.medicas.model.Paciente;
import com.citas.medicas.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Obtener todos los pacientes
    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteService.obtenerTodosLosPacientes();
    }

    // Obtener un paciente por ID
    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    // Crear un nuevo paciente
    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    // Actualizar un paciente
    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteActualizado) {
        return pacienteService.actualizarPaciente(id, pacienteActualizado);
    }

    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
}

