package com.finalproject.sistemaTurnosClinicaDental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioAppController {

    @GetMapping("/")
    public String home() {
        return "<h1> Bienvenid@ </h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1> Bienvenid@ Usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1> Bienvenid@ Admin </h1>";
    }
}
