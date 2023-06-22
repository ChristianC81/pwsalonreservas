/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Persona;
import com.tapgroup.pwsalonreservas.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements GenericService<Persona, Integer> {

    @Autowired
    PersonaRepository rolRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return rolRepository;
    }

    public boolean validarPersona(String persDniPasaporte) {
        return rolRepository.validarPersona(persDniPasaporte);
    }


   


}

