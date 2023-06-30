/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@Entity
public class Detalle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int deId;

    @Column(name = "cantidad")
    private double deCantidadpedida;

    //@NotBlank(message = "La detalle no puede estar en blanco")
    @Column(name = "garantiadanos")
    private double deGarantiadanos;

    @Column(name = "preciounitario")
    private double dePreciounitario;

    // muchos complementos tienen un salon
    @ManyToOne
    @JoinColumn(name = "id_salon", referencedColumnName = "id_salon")
    private Salon salon;
    
    
}
