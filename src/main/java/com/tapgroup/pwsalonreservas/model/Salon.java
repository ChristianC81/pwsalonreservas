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
    private int salId;

    @Size(min = 3, max = 10, message = "El nombre del salon debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La salon no puede estar en blanco")
    @Column(name = "nombre")
    private String salNombre;

    @Column(name = "descripcion")
    private String salDescripcion;

    @Column(name = "ubicacion")
    private String salUbicacion;

    @Column(name = "direccion")
    private String salDireccion;

    @Column(name = "precioSalon")
    private double salPrecio;

    @Column(name = "disponibilidad")
    private boolean salDisponibilidad;

    @Column(name = "capacidad")
    private int salCapacidad;

//    @Column(name = "categoria")
//    private String pubCategoria;
    //Muchos salones un usuario (Publicador)
    @ManyToOne
    @JoinColumn(name = "id_usuariopublicador", referencedColumnName = "id_usuario")
    private Usuario usuariopublicador;

    //Un salon muchas calificaciones
    @JsonIgnore
    @OneToMany(mappedBy = "salon")
    private List<Calificacion> listaCalificaciones;

    //Un salon un pedido
    @OneToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    //Un salon tiene uno o muchos complementos
    @JsonIgnore
    @OneToMany(mappedBy = "salon")
    private List<Complemento> listaComplementos;
}
