package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="UserRoles",
            joinColumns = @JoinColumn(name="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_rol")
    )
    private Set<Rol> roles;

}

// Si no corre automaticamente el archivo import.sql crear roles,
// Usuarios y sus relaciones
// INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');
//INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');
//INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES (1, 1), (1,2), (2, 2);
