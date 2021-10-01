package com.example.demo.service;


import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void createOdontologo(Odontologo o) {

        odontologoRepository.save(o);
    }

    @Override
    public OdontologoDTO readOdontologo (Long id) throws Exception {

        //OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> found = odontologoRepository.findById(id);
        if(found.isPresent()) {
            return mapper.convertValue(found, OdontologoDTO.class);
        }else {
            throw new Exception("Odontólogo no encontrado");
        }
    }

    @Override
    public void updateOdontologo(OdontologoDTO o) {

        if(odontologoRepository.findById(o.getId())!= null){
            Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
            odontologoRepository.save(odontologo);
        }

    }

    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<OdontologoDTO>();
        for(Odontologo odontologo: odontologos)
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return odontologosDTO;
    }

    @Override
    public Set<OdontologoDTO> getOdontologoWithLastname(String apellido) {
        Set<Odontologo> odontologos = odontologoRepository.getOdontologoByLastname(apellido);
        Set<OdontologoDTO> odontologosDTO = new HashSet<OdontologoDTO>();
        for(Odontologo odontologo: odontologos)
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return odontologosDTO;
    }
}