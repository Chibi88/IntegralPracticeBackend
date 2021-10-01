package com.example.demo.service;

import com.example.demo.model.*;

import java.util.Collection;
import java.util.Optional;

public interface ITurnoService {

     Turno createTurno(Turno turno);
     Collection<Turno> getAll() ;

     Turno updateTurno (Turno turno);
     void deleteTurno(Long id);
     Optional<Turno> readTurno (Long id)throws Exception;
}

