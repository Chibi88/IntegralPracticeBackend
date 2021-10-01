package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;

    @Test
    public void testGetPacientesWithLastnameLike(){

        Paciente paciente = new Paciente();
        paciente.setApellido("pruebaLastName");
        paciente.setNombre("pruebaName");

        pacienteService.createPaciente(paciente);
        Set<PacienteDTO> pacientes = pacienteService.getPacienteWithLastname("prueba");

        boolean resultado = pacientes.size() > 0;

        assertTrue(resultado);
    }
}