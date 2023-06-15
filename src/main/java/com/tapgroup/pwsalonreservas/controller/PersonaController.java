/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Persona;
import com.tapgroup.pwsalonreservas.service.PersonaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonny
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
     @Autowired
     PersonaServiceImpl personaService;

    @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaPersonas() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Persona")
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona p) {
        return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona p) {
        Persona per = personaService.findById(id);
        if (per != null) {
            try {
                
                per.setDni_pasaporte(p.getDni_pasaporte());
                per.setNombre(p.getNombre());
                per.setApellido(p.getApellido());
                per.setEmail(p.getEmail());
                per.setTelefono(p.getTelefono());
                per.setCelular(p.getCelular());
                per.setFecha_nac(p.getFecha_nac());
                
              
                return new ResponseEntity<>(personaService.save(per), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Integer id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
