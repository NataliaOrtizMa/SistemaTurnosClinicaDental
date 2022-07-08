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
    private String DNI;

    private Date fechaIngreso;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Turno> turnos;
}
