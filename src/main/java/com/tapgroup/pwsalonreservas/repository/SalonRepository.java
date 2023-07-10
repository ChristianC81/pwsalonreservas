/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;


import com.tapgroup.pwsalonreservas.model.Salon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface SalonRepository extends JpaRepository<Salon, Integer>{
    
        @Query(value = "Select * from salon s where s.nombre = :nombre", nativeQuery = true)
    public Salon buscarSalon(String nombre);
    
    @Query("SELECT s FROM Salon s WHERE s.salonEstado = 'Activo'")
    List<Salon> getSalonesActivos();
    
    @Query("SELECT s FROM Salon s WHERE s.salonEstado = 'Inactivo'")
    List<Salon> getSalonesInactivos();
}
