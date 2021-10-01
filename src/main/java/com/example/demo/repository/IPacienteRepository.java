package com.example.demo.repository;

import com.example.demo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    //HQL
    @Query("from Paciente p where p.apellido like %:apellido%") //from = nombre de la clase
    Set<Paciente> getPacienteByLastname(@Param("apellido") String apellido);


}

//todos los metodos customizados van aca