/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.repository;

import com.tapgroup.pwsalonreservas.model.GrupoComplemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface GrupoComplementoRepository extends JpaRepository<GrupoComplemento, Integer> {

    @Query(value = "Select * from grupocomplemento u where u.comgrupo_id = :comgrupo_id", nativeQuery = true)
    public GrupoComplemento buscarGrupoComplemento(int comgrupo_id);

    @Query(value = "SELECT g.id_grupocomplemento FROM grupo_complemento g ORDER BY g.id_grupocomplemento DESC LIMIT 1", nativeQuery = true)
    Integer obtenerUltimoIdGrupoComplemento();


}
