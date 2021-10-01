package com.example.demo.controller;


import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.model.Turno;
import com.example.demo.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final static Logger logger = Logger.getLogger("Logs turnos");

    @Autowired
    ITurnoService turnoService;

    @PostMapping()
    public ResponseEntity<?> createTurno(@RequestBody Turno turno) {
        turnoService.createTurno(turno);
        logger.debug("Registrando turno nuevo");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;
        if (turno.getId() != null) {
            logger.debug("Modificando turno existente");
            turnoService.createTurno(turno);
            return ResponseEntity.ok(turno);
        }
        logger.debug("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> getById(@PathVariable Long id) throws Exception {
        if (id != null) {
            logger.debug("Consultando turno particular");
            return ResponseEntity.ok(turnoService.readTurno(id));
        }
        logger.debug("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/list")
    public Collection<Turno> getAll() {
        logger.debug("Consultando turnos");
        return turnoService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws Exception {
        if(turnoService.readTurno(id).isPresent()){
            logger.debug("Borrando turno particular");
            turnoService.deleteTurno(id);
            return "El turno con id " + id + " se ha eliminado con éxito ";
        }
        logger.debug("Falló la petición o el turno no existe");
        return "No se encontro ningún turno con id " + id;
    }

}
