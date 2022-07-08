package com.finalproject.sistemaTurnosClinicaDental.service.impl;

import com.finalproject.sistemaTurnosClinicaDental.entity.Odontologo;
import com.finalproject.sistemaTurnosClinicaDental.repository.OdontologoRepository;
import com.finalproject.sistemaTurnosClinicaDental.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OdontologoServiceImpl implements OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoServiceImpl.class);

    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {
        LOGGER.info("Creando nuevo odontólogo");
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarOdontologoById(Long id) {
        LOGGER.info("Buscando odontologo " + id);
        return odontologoRepository.findById(id).get();
    }

    @Override
    public List<Odontologo> buscarOdontologos() {
        LOGGER.info("Buscando todos los odontólogos");
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        LOGGER.info("Actualizando odontólogo");
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        LOGGER.info("Eliminando odontólgo");
        // Librería Objects permite hacer validaciones tratando nulos
        if (Objects.nonNull(buscarOdontologoById(id))) {
            odontologoRepository.deleteById(id);
        }
    }
}
