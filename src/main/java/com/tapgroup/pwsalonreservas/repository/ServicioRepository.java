/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;


import com.tapgroup.pwsalonreservas.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
        @Query(value = "Select * from complemento u where u.nombre = :nombre", nativeQuery = true)
    public Servicio buscarComplemento(String nombre);
}
