/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author chris
 */
@Data
@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salon")
    private int id_salon;

     @OneToOne
    @JoinColumn(name = "id_usuariopublicador", referencedColumnName = "id_persona")
    private Usuario usuariopublicador;
     
    @Size(min = 3, max = 10, message = "El nombre del salon debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La salon no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

      @Column(name = "capacidad")
    private int capacidad;
      
      @Column(name = "disponibilidad")
    private boolean disponibilidad;
      
    @Column(name = "descripcion")
    private String descripcion;
    
     @Column(name = "categoria")
    private String categoria;

     @Column(name = "foto")
    private String foto;

     @Column(name = "ubicacion")
    private String ubicacion;
     
     @Column(name = "precioSalon")
    private double precioSalon;
     
    @Column(name = "calificacion")
    private String calificacion;
   
    

}
