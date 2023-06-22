/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Publicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.tapgroup.pwsalonreservas.repository.PublicacionRepository;

/**
 *
 * @author chris
 */
@Service
public class PublicacionServiceImpl extends GenericServiceImpl<Publicacion, Integer> implements GenericService<Publicacion, Integer> {

    @Autowired
    PublicacionRepository salonRepository;

    @Override
    public CrudRepository<Publicacion, Integer> getDao() {
        return salonRepository;
    }


}

