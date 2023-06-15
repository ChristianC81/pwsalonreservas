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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;


/**
 *
 * @author chris
 */

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int id_pedido;

    
    @Column(name = "cantidad")
    private String cantidad;
    
    @Column(name = "preciocomplementos")
    private double preciocomplementos;
    
    @Column(name = "preciototal")
    private double preciototal;
    
    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "comprobantedepago")
    private String comprobantedepago;
    
  
}
