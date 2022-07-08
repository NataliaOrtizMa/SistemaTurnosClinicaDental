package com.finalproject.sistemaTurnosClinicaDental.service;

import com.finalproject.sistemaTurnosClinicaDental.entity.Odontologo;

import java.util.List;

public interface OdontologoService {
    Odontologo crearOdontologo(Odontologo odontologo);
    Odontologo buscarOdontologoById(Long id);
    List<Odontologo> buscarOdontologos();
    Odontologo actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
}
