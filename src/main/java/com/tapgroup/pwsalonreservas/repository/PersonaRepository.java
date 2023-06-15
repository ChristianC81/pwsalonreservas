/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;


import com.tapgroup.pwsalonreservas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
        @Query(value = "Select * from persona u where u.dni_pasaporte = :dni_pasaporte", nativeQuery = true)
    public Persona buscarPersona(String dni_pasaporte);
}
