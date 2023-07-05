/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Complemento;
import com.tapgroup.pwsalonreservas.service.ComplementoServiceImpl;
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
@RequestMapping("/api/complemento")
public class ComplementoController {

    @Autowired
    ComplementoServiceImpl complementoService;

    @Operation(summary = "Se obtiene la lista de Complementos")
    @GetMapping("/listar")
    public ResponseEntity<List<Complemento>> listaComplementoes() {
        return new ResponseEntity<>(complementoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Complemento")
    @PostMapping("/crear")
    public ResponseEntity<Complemento> crearComplemento(@RequestBody Complemento c) {
        return new ResponseEntity<>(complementoService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Complemento> actualizarComplemento(@PathVariable Integer id, @RequestBody Complemento c) {
        Complemento com = complementoService.findById(id);
        if (com != null) {
            try {

                com.setComNombre(c.getComNombre());
                com.setComDescripcion(c.getComDescripcion());
                com.setComCantidadbase(c.getComCantidadbase());
                com.setComCantidadrestante(c.getComCantidadrestante());
                com.setComPrecioUnitario(c.getComPrecioUnitario());
                

                return new ResponseEntity<>(complementoService.save(com), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Complemento> eliminarComplemento(@PathVariable Integer id) {
        complementoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
