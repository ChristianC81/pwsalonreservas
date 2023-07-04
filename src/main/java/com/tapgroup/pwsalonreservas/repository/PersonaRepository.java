/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;

import com.tapgroup.pwsalonreservas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author chris
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT COUNT(p)>0 FROM Persona p WHERE p.persDniPasaporte = :dni")
    boolean validarPersona(@Param("dni") String persDniPasaporte);
    
    @Query("SELECT COUNT(p)> 0 FROM Persona p WHERE p.persEmail= :email")
    boolean validarEmail(@Param("email") String persEmail);
}
