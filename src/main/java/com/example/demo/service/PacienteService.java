package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;


    @Autowired
    ObjectMapper mapper;

    @Override
    public void createPaciente(Paciente p) {

        pacienteRepository.save(p);
    }

     @Override
    public PacienteDTO readPaciente(Long id) throws Exception {

         //PacienteDTO pacienteDTO = null;
        Optional<Paciente> found = pacienteRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, PacienteDTO.class);
        else
            throw new Exception("Paciente no encontrado");

    }

    @Override
    public void updatePaciente(PacienteDTO p) {

        if (pacienteRepository.findById(p.getId()) != null){
            Paciente paciente = mapper.convertValue(p, Paciente.class);
            pacienteRepository.save(paciente);
        }

    }

   @Override
    public void deletePaciente(Long id) {

        pacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<PacienteDTO>();
        for(Paciente paciente: pacientes)
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return pacientesDTO;
    }

    @Override
    public Set<PacienteDTO> getPacienteWithLastname(String apellido) {
        Set<Paciente> pacientes = pacienteRepository.getPacienteByLastname(apellido);
        Set<PacienteDTO> pacientesDTO = new HashSet<PacienteDTO>();
        for(Paciente paciente: pacientes)
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return pacientesDTO;
    }
}
