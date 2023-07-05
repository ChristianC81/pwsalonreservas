/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Detalle;
import com.tapgroup.pwsalonreservas.service.DetalleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    @Autowired
    DetalleServiceImpl detalleService;

    @Operation(summary = "Se obtiene la lista de Detalles")
    @GetMapping("/listar")
    public ResponseEntity<List<Detalle>> listaDetallees() {
        return new ResponseEntity<>(detalleService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Detalle")
    @PostMapping("/crear")
    public ResponseEntity<Detalle> crearDetalle(@RequestBody Detalle d) {
        return new ResponseEntity<>(detalleService.save(d), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Detalle> actualizarDetalle(@PathVariable Integer id, @RequestBody Detalle d) {
        Detalle de = detalleService.findById(id);
        if (de != null) {
            try {

                de.setDeCantidadpedida(d.getDeCantidadpedida());
                de.setDeGarantiadanos(d.getDeGarantiadanos());
                de.setDePreciounitario(d.getDePreciounitario());
                //
                de.setComplemento(d.getComplemento());
                

                return new ResponseEntity<>(detalleService.save(de), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Detalle> eliminarDetalle(@PathVariable Integer id) {
        detalleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
