/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Detalle;
import com.tapgroup.pwsalonreservas.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class DetalleServiceImpl extends GenericServiceImpl<Detalle, Integer> implements GenericService<Detalle, Integer> {

    @Autowired
    DetalleRepository detalleRepository;

    @Override
    public CrudRepository<Detalle, Integer> getDao() {
        return detalleRepository;
    }

}
