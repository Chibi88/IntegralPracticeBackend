package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
@Setter
@Getter
public class Rol {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}

// Si no corre automaticamente el archivo import.sql crear roles,
// Usuarios y sus relaciones
// INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');
//INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');
//INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES (1, 1), (1,2), (2, 2);