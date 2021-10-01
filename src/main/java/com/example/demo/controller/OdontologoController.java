package com.example.demo.controller;


import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    private Logger logger = Logger.getLogger("logs odontologos");

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> addOdontologo(@RequestBody Odontologo o) {
        odontologoService.createOdontologo(o);
        logger.debug("Registrando un nuevo odontologo");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id) throws Exception {
        logger.debug("Consultando odontologo existente");
        return odontologoService.readOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null){
            logger.debug("Odontologo modificado");
            odontologoService.createOdontologo(odontologo);
            return ResponseEntity.ok(odontologo);
        }
        logger.debug("Falló la petición o el odontologo no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOdontologo(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        odontologoService.deleteOdontologo(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<OdontologoDTO> listOdontologo() {
        return odontologoService.getAll();
    }

    @GetMapping("/getLastname")
    public Set<OdontologoDTO> listOdontologoWithLastname(@RequestParam String apellido) {
        return odontologoService.getOdontologoWithLastname(apellido);
    }


}
