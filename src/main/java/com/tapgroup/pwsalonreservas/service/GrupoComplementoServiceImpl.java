/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.service;

import com.tapgroup.pwsalonreservas.model.GrupoComplemento;
import com.tapgroup.pwsalonreservas.repository.ComplementoRepository;
import com.tapgroup.pwsalonreservas.repository.GrupoComplementoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class GrupoComplementoServiceImpl extends GenericServiceImpl<GrupoComplemento, Integer> implements GenericService<GrupoComplemento, Integer> {

    @Autowired
    GrupoComplementoRepository grupocomplementoRepository;

    public int ultimoid() {
        return grupocomplementoRepository.obtenerUltimoIdGrupoComplemento();
    }

    @Override
    public CrudRepository<GrupoComplemento, Integer> getDao() {
        return grupocomplementoRepository;
    }

}
