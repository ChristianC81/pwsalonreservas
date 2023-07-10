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
@RequestMapping("api/salon")
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

                sa.setSalonNombre(s.getSalonNombre());
                sa.setSalonDescripcion(s.getSalonDescripcion());
                sa.setSalonCapacidad(s.getSalonCapacidad());
                sa.setSalonDireccion(s.getSalonDireccion());
                sa.setSalonLongitud(s.getSalonLongitud());
                sa.setSalonLatitud(s.getSalonLatitud());
                sa.setSalonPrecio(s.getSalonPrecio());
                sa.setSalonCategoria(s.getSalonCategoria());
                sa.setSalonFoto(s.getSalonFoto());
                sa.setSalonEstado(s.getSalonEstado());
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

    //Metodo listar salones activos
    @GetMapping("/activos")
    public ResponseEntity<List<Salon>> listaSalonesActivos() {
        List<Salon> salonesActivos = salonService.salonesActivos();
        return new ResponseEntity<>(salonesActivos, HttpStatus.OK);
    }

    //Metodo listar salones inactivos
    @GetMapping("/inactivos")
    public ResponseEntity<List<Salon>> listaSalonesInactivos() {
        List<Salon> salonesInactivos = salonService.salonesInactivos();
        return new ResponseEntity<>(salonesInactivos, HttpStatus.OK);
    }

    //Metodo para actualizar estado
    @PutMapping("/actualizarest/{id}")
    public ResponseEntity<Salon> actualizarEstadoSalon(@PathVariable Integer id, @RequestBody Salon s) {
        Salon sal = salonService.findById(id);
        if (sal != null) {
            try {
                sal.setSalonEstado(s.getSalonEstado());
                return new ResponseEntity<>(salonService.save(sal), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
