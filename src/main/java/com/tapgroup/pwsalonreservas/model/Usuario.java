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
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 *
 * @author chris
 */
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int usuId;

    @Column(name = "nombre_usuario")
    private String usuNombre;

    @Column(name = "contrasenia")
    private String usuContrasenia;

    @NotBlank(message = "El estado no puede estar en blanco")
    @Column(name = "estado")
    private String usuEstado;

    //Muchos usuarios una persona
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    //Muchos usuarios un rol
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;

    //Un usuario muchas calificaciones
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> listaCalificaciones;

    //Un usuario muchos salones (Publicador)
    @JsonIgnore
    @OneToMany(mappedBy = "usuariopublicador")
    private List<Salon> listaSalones;

    //Un usuario muchos pedidos
    @JsonIgnore
    @OneToMany(mappedBy = "usuario_pedido")
    private List<Pedido> listaPedidos;

}
