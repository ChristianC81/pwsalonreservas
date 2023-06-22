/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Salon;
import com.tapgroup.pwsalonreservas.service.SalonServiceImpl;
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
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    SalonServiceImpl salonService;

    @Operation(summary = "Se obtiene la lista de Salones")
    @GetMapping("/listar")
    public ResponseEntity<List<Salon>> listaSalones() {
        return new ResponseEntity<>(salonService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Salon")
    @PostMapping("/crear")
    public ResponseEntity<Salon> crearSalon(@RequestBody Salon s) {
        return new ResponseEntity<>(salonService.save(s), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Salon> actualizarSalon(@PathVariable Integer id, @RequestBody Salon s) {
        Salon sa = salonService.findById(id);
        if (sa != null) {
            try {

                sa.setSalNombre(s.getSalNombre());
                sa.setSalDescripcion(s.getSalDescripcion());
                sa.setSalCapacidad(s.getSalCapacidad());
                //sa.setDisponibilidad(s.getd);
                sa.setSalDireccion(s.getSalDireccion());
                sa.setSalUbicacion(s.getSalUbicacion());
                sa.setSalPrecio(s.getSalPrecio());
//                sa.setUsuariopublicador(s.getUsuariopublicador());

                return new ResponseEntity<>(salonService.save(sa), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Salon> eliminarSalon(@PathVariable Integer id) {
        salonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
