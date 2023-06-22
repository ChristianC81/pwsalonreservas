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
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int persId;

     @Column(name = "dni_pasaporte")
    private String persDniPasaporte;
    
    //@Size(min = 3, max = 10, message = "La persona debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "La persona no puede estar en blanco")
    @Column(name = "nombre")
    private String persNombre;

    //@NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "apellido")
    private String persApellido;

    //@Email(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "email")
    private String persEmail;
      
    @Column(name = "telefono")
    private String persTelefono;
      
    @Column(name = "celular")
    private String perscelular;

    @Column(name = "fecha_nac")
    private Date persFechaNac;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> listaUsuarios;

    

}
