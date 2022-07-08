package com.finalproject.sistemaTurnosClinicaDental.controller;

import com.finalproject.sistemaTurnosClinicaDental.entity.Turno;
import com.finalproject.sistemaTurnosClinicaDental.service.OdontologoService;
import com.finalproject.sistemaTurnosClinicaDental.service.PacienteService;
import com.finalproject.sistemaTurnosClinicaDental.service.TurnoService;
import com.finalproject.sistemaTurnosClinicaDental.service.impl.TurnoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger LOGGER = Logger.getLogger(TurnoController.class);
    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService,
            OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping("/crearTurno")
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno) {
        LOGGER.debug("Controller Turno");
        return ResponseEntity.ok(turnoService.crearTurno(turno));
    }
}
