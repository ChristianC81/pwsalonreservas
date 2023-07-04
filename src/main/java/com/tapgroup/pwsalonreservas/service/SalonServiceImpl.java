/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Salon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.tapgroup.pwsalonreservas.repository.SalonRepository;
import java.util.List;

/**
 *
 * @author chris
 */
@Service
public class SalonServiceImpl extends GenericServiceImpl<Salon, Integer> implements GenericService<Salon, Integer> {

    @Autowired
    SalonRepository salonRepository;
    
    
    public List salonesActivos(){
        return salonRepository.getSalonesActivos();
    }
    
    public List salonesInactivos(){
        return salonRepository.getSalonesInactivos();
    }

    @Override
    public CrudRepository<Salon, Integer> getDao() {
        return salonRepository;
    }


}

