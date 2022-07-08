package com.finalproject.sistemaTurnosClinicaDental.service.impl;

import com.finalproject.sistemaTurnosClinicaDental.entity.Odontologo;
import com.finalproject.sistemaTurnosClinicaDental.entity.Paciente;
import com.finalproject.sistemaTurnosClinicaDental.entity.Turno;
import com.finalproject.sistemaTurnosClinicaDental.repository.OdontologoRepository;
import com.finalproject.sistemaTurnosClinicaDental.repository.PacienteRepository;
import com.finalproject.sistemaTurnosClinicaDental.repository.TurnoRepository;
import com.finalproject.sistemaTurnosClinicaDental.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    private static final Logger LOGGER = Logger.getLogger(TurnoServiceImpl.class);

    private final TurnoRepository turnoRepository;
    private final PacienteRepository pacienteRepository;
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository,
            PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository) {
        this.turnoRepository = turnoRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Turno crearTurno(Turno turno) {
        LOGGER.info("Creando nuevo turno");

        Optional<Odontologo> odontologo = odontologoRepository.findById(turno.getOdontologo().getId());
        Optional<Paciente> paciente = pacienteRepository.findById(turno.getPaciente().getId());
        turno.setOdontologo(odontologo.get());
        turno.setPaciente(paciente.get());

        turno.setFecha(new Date());
        return turnoRepository.save(turno);
    }
}
