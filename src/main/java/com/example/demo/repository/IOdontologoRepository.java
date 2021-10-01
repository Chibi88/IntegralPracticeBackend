package com.example.demo.repository;

import com.example.demo.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    //HQL
    @Query("from Odontologo o where o.apellido like %:apellido%") //from = nombre de la clase
    Set<Odontologo> getOdontologoByLastname(@Param("apellido") String apellido);
}
