package com.finalproject.sistemaTurnosClinicaDental.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String nombre;
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    private Direccion direccion;

    @Column(unique = true)
    private String dni;

    private Date fechaIngreso;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Turno> turnos;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String dni, Date fechaIngreso,
            Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.direccion = direccion;
    }

    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso,
            Direccion direccion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.direccion = direccion;
    }
}
