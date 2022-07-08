package com.finalproject.sistemaTurnosClinicaDental.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usuarios_app")
public class UsuarioApp {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;
    private String name;

    @Column(unique = true)
    private String username;

    private String email;
    private String contraseña;

    //@Enumerated(EnumType.STRING)
    //private UsuarioApp appUserRole;
}
