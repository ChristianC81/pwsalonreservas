/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;


import com.tapgroup.pwsalonreservas.model.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface ComplementoRepository extends JpaRepository<Complemento, Integer>{
        @Query(value = "Select * from complemento u where u.nombre = :nombre", nativeQuery = true)
    public Complemento buscarComplemento(String nombre);
}
