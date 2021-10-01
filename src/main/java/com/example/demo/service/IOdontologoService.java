package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;

import java.util.Collection;
import java.util.Set;

public interface IOdontologoService {


    public void createOdontologo(Odontologo o);
    public OdontologoDTO readOdontologo (Long id) throws Exception;
    public void updateOdontologo(OdontologoDTO o);
    public void deleteOdontologo(Long id);
    public Collection<OdontologoDTO> getAll();
    public Set<OdontologoDTO> getOdontologoWithLastname(String apellido);
}