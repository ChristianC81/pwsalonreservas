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
public class Complemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_complemento")
    private int comId;

    @Column(name = "nombre")
    private String comNombre;

    @NotBlank(message = "La detalle no puede estar en blanco")
    @Column(name = "descripcion")
    private String comDescripcion;

    @Column(name = "cantidadbase")
    private int comCantidadbase;

    @Column(name = "cantidadrestante")
    private int comCantidadrestante;

    @Column(name = "precioUnitario")
    private double comPrecioUnitario;

    // muchos complementos tienen un salon
    @ManyToOne
    @JoinColumn(name = "id_salon", referencedColumnName = "id_salon")
    private Salon salon;

    //Un complemento a muchos detalles
    @JsonIgnore
    @OneToMany(mappedBy = "complemento")
    private List<Detalle> listaDetalles;

}
