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
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int rolId;

    @Size(min = 3, max = 20, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El nombre de rol no puede estar en blanco")
    @Column(name = "nombre")
    private String rolNombre;

    @NotBlank(message = "La detalle no puede estar en blanco")
    @Column(name = "descripcion")
    private String rolDescripcion;

    @JsonIgnore
    @OneToMany(mappedBy="rol")
    private List<Usuario> listUsu;

}
