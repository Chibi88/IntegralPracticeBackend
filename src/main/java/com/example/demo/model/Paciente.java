package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pacientes")
@Getter @Setter


public class Paciente {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String dni;
    private Date fechaDeIngreso;
    private String domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    //@JoinColumn
    private Set<Turno> turnos;


}
