/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.tapgroup.pwsalonreservas.repository.ServicioRepository;

/**
 *
 * @author chris
 */
@Service
public class ServicioServiceImpl extends GenericServiceImpl<Servicio, Integer> implements GenericService<Servicio, Integer> {

    @Autowired
    ServicioRepository complementoRepository;

    @Override
    public CrudRepository<Servicio, Integer> getDao() {
        return complementoRepository;
    }


}

