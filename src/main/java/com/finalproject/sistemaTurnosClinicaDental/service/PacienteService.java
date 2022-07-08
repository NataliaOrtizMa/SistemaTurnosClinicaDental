package com.finalproject.sistemaTurnosClinicaDental.service;

import com.finalproject.sistemaTurnosClinicaDental.entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente crearPaciente(Paciente paciente);
    Paciente buscarPacienteById(Long id);
    List<Paciente> buscarPacientes();
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
}
