/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.Pedido;
import com.tapgroup.pwsalonreservas.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Integer> implements GenericService<Pedido, Integer> {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public CrudRepository<Pedido, Integer> getDao() {
        return pedidoRepository;
    }


}

