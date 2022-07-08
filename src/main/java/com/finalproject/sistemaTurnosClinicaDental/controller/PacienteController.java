package com.finalproject.sistemaTurnosClinicaDental.controller;

import com.finalproject.sistemaTurnosClinicaDental.entity.Paciente;
import com.finalproject.sistemaTurnosClinicaDental.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/crearPaciente")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPacienteById(id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarPacientes() {
        return ResponseEntity.ok(pacienteService.buscarPacientes());
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) {
        if (paciente.getId() != null && pacienteService.buscarPacienteById(paciente.getId()) != null) {
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente eliminado con " + "éxito");
    }
}
