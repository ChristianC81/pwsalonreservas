/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
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

    //Muchos complementos a un detalle
    @ManyToOne
    @JoinColumn(name = "id_complemento", referencedColumnName = "id_complemento")
    private Complemento complemento;
}
