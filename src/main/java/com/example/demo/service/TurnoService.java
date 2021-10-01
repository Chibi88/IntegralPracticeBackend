package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.model.Turno;
import com.example.demo.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;


    @Override
    public Turno createTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Collection<Turno> getAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno updateTurno(Turno turno) {
        if(turnoRepository.findById(turno.getId()) != null) {
            return turnoRepository.save(turno);
        }
        return null;
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Optional<Turno> readTurno(Long id) throws Exception {
        Optional <Turno> found = turnoRepository.findById(id);
        if (found.isPresent())
            return found;
        else
            throw new Exception("Turno no existente");

    }
}
