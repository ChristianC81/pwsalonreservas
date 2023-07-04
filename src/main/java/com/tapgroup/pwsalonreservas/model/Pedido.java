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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
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
    private int pedId;

    @Column(name = "cantidad")
    private int pedCantidad;

    @Column(name = "preciocomplementos")
    private double pedPreciocomplementos;

    @Column(name = "preciototal")
    private double pedPreciototal;

    @Column(name = "observacion")
    private String pedObservacion;

    @Column(name = "estadodepago")
    private Boolean pedEstadopago;

    @Column(name = "fechainicio")
    private Date pedFechaInicio;

    @Column(name = "fechafin")
    private Date pedFechaFin;

    // Muchos pedidos a un Usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario_reservador", referencedColumnName = "id_usuario")
    private Usuario usuario_pedido;

    //Un salon un pedido
    @OneToOne
    @JoinColumn(name = "id_salon", referencedColumnName = "id_salon")
    private Salon salon;

    //Un detalle a un pedido
    @OneToOne
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle")
    private Detalle detalle;

}
