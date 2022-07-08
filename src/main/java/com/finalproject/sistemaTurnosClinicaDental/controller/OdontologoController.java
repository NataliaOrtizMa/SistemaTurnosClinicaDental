package com.finalproject.sistemaTurnosClinicaDental.controller;

import com.finalproject.sistemaTurnosClinicaDental.entity.Odontologo;
import com.finalproject.sistemaTurnosClinicaDental.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/crearOdontologo")
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoById(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologoById(id);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarOdontologos() {
        return ResponseEntity.ok(odontologoService.buscarOdontologos());
    }

    @PutMapping("/update")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) {
        if (odontologo.getId() != null && odontologoService.buscarOdontologoById(odontologo.getId()) != null) {
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado con " +
                                                                         "éxito");
    }
}
