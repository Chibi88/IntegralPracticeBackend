package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;

import java.util.Collection;
import java.util.Set;

public interface IPacienteService {

    public void createPaciente(Paciente p);
    public PacienteDTO readPaciente(Long id) throws Exception;
    public void updatePaciente(PacienteDTO p);
    public void deletePaciente(Long id);
    public Collection<PacienteDTO> getAll();
    public Set<PacienteDTO> getPacienteWithLastname(String apellido);


}
