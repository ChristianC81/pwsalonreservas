/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Complemento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.tapgroup.pwsalonreservas.repository.ComplementoRepository;

/**
 *
 * @author chris
 */
@Service
public class ComplementoServiceImpl extends GenericServiceImpl<Complemento, Integer> implements GenericService<Complemento, Integer> {

    @Autowired
    ComplementoRepository complementoRepository;

    @Override
    public CrudRepository<Complemento, Integer> getDao() {
        return complementoRepository;
    }


}

