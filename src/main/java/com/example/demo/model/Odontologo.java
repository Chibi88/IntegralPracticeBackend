package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
@Getter
@Setter
public class Odontologo {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo") //agregar cascade para eliminar turnos del odontologo, si se elimina el mismo
    @JsonIgnore
    private Set<Turno> turnos;
}
