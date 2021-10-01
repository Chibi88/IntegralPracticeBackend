package com.example.demo.controller;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private Logger logger = Logger.getLogger("Logueos");

    @Autowired
    IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> addPaciente(@RequestBody Paciente p) {
        pacienteService.createPaciente(p);
        logger.debug("Registrando paciente nuevo");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id) throws Exception {
        logger.debug("Consultando paciente existente");
        return pacienteService.readPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null){
            logger.debug("Modificando paciente existente");
            pacienteService.createPaciente(paciente);
            return ResponseEntity.ok(paciente);
        }
        logger.debug("Falló la petición o el paciente no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePaciente(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        logger.debug("Eliminando paciente..");
        pacienteService.deletePaciente(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<PacienteDTO> listPacientes() {
        logger.debug("Consultando pacientes");
        return pacienteService.getAll();
    }

    @GetMapping("/getLastname")
    public Set<PacienteDTO> listPacientesWithLastname(@RequestParam String apellido) {
        logger.debug("Consultando paciente por apellido");
        return pacienteService.getPacienteWithLastname(apellido);
    }


}
