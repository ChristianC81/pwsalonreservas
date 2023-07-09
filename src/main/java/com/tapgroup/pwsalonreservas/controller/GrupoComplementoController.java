/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.GrupoComplemento;
import com.tapgroup.pwsalonreservas.service.GrupoComplementoServiceImpl;
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
@RequestMapping("/api/grupocomplemento")
public class GrupoComplementoController {

    @Autowired
    GrupoComplementoServiceImpl grupocomplementoService;

    @Operation(summary = "Se obtiene la lista de Grupo Complemento")
    @GetMapping("/listar")
    public ResponseEntity<List<GrupoComplemento>> listarGrupoComplementos() {
        return new ResponseEntity<>(grupocomplementoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Grupo Complemento")
    @PostMapping("/crear")
    public ResponseEntity<GrupoComplemento> crearGrupoComplemento(@RequestBody GrupoComplemento c) {
        return new ResponseEntity<>(grupocomplementoService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<GrupoComplemento> actualizarGrupoComplemento(@PathVariable Integer id, @RequestBody GrupoComplemento c) {
        GrupoComplemento com = grupocomplementoService.findById(id);
        if (com != null) {
            try {

                return new ResponseEntity<>(grupocomplementoService.save(com), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<GrupoComplemento> eliminarGrupoComplemento(@PathVariable Integer id) {
        grupocomplementoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Metodos personalizados
    //Obtener el ultimo id 
    @GetMapping("/ultimoidgrupocom")
    public ResponseEntity<Integer> ultimoidgrupocom() {
        int ultimoid = grupocomplementoService.ultimoid();
        return new ResponseEntity<>(ultimoid, HttpStatus.OK);
    }

}
