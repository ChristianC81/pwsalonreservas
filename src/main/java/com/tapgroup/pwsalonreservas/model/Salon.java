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
    private int salonId;

    @Size(min = 3, max = 10, message = "El nombre del salon debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El salon no puede estar en blanco")
    @Column(name = "nombre")
    private String salonNombre;

    @Column(name = "descripcion")
    private String salonDescripcion;

    @Column(name = "longitud")
    private double salonLongitud;

    @Column(name = "latitud")
    private double salonLatitud;

    @Column(name = "direccion")
    private String salonDireccion;

    @Column(name = "precioSalon")
    private double salonPrecio;

    @Column(name = "disponibilidad")
    private boolean salonDisponibilidad;

    @Column(name = "capacidad")
    private int salonCapacidad;

    @Column(name = "categoria")
    private String salonCategoria;

    @Column(name = "foto")
    private String salonFoto;

    @Column(name = "estado")
    private String salonEstado;

    //Muchos salones un usuario (Publicador)
    @ManyToOne
    @JoinColumn(name = "id_usuariopublicador", referencedColumnName = "id_usuario")
    private Usuario usuariopublicador;

    //Un salon muchas calificaciones
    @JsonIgnore
    @OneToMany(mappedBy = "salon")
    private List<Calificacion> listaCalificaciones;

    //Un salon tiene uno o muchos complementos
    @JsonIgnore
    @OneToMany(mappedBy = "salon")
    private List<Complemento> listaComplementos;

    //Un grupo complemento a un salon
    @OneToOne
    @JoinColumn(name = "id_grupocomplemento", referencedColumnName = "id_grupocomplemento")
    private GrupoComplemento grupocomplemento;

}
