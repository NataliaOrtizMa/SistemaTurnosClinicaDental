package com.finalproject.sistemaTurnosClinicaDental.excepciones;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
