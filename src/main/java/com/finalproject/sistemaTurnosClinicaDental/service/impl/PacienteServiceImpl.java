package com.finalproject.sistemaTurnosClinicaDental.service.impl;

import com.finalproject.sistemaTurnosClinicaDental.entity.Paciente;
import com.finalproject.sistemaTurnosClinicaDental.repository.PacienteRepository;
import com.finalproject.sistemaTurnosClinicaDental.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class PacienteServiceImpl implements PacienteService {
    private static final Logger LOGGER = Logger.getLogger(PacienteServiceImpl.class);

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        LOGGER.info("Creando nuevo paciente");
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPacienteById(Long id) {
        LOGGER.info("Buscando paciente " + id);
        return pacienteRepository.findById(id).get();
    }

    @Override
    public List<Paciente> buscarPacientes() {
        LOGGER.info("Buscando todos los pacientes");
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        LOGGER.info("Actualizando paciente");
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        LOGGER.info("Eliminando paciente");
        if (Objects.nonNull(buscarPacienteById(id))) {
            pacienteRepository.deleteById(id);
        }
    }
}
