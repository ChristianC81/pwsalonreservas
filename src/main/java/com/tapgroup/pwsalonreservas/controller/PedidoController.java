/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Pedido;
import com.tapgroup.pwsalonreservas.service.PedidoServiceImpl;
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
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoServiceImpl pedidoService;

    @Operation(summary = "Se obtiene la lista de Pedidos")
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listaPedidoes() {
        return new ResponseEntity<>(pedidoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de Pedido")
    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido p) {
        return new ResponseEntity<>(pedidoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido p) {
        Pedido pe = pedidoService.findById(id);
        if (pe != null) {
            try {

                pe.setPedCantidad(p.getPedCantidad());
                pe.setPedPreciocomplementos(p.getPedPreciocomplementos());
                pe.setPedPreciototal(p.getPedPreciototal());
                pe.setPedObservacion(p.getPedObservacion());
                pe.setPedEstadopago(p.getPedEstadopago());
                pe.setPedFechaInicio(p.getPedFechaInicio());
                pe.setPedFechaFin(p.getPedFechaFin());
                //
                pe.setSalon(p.getSalon());
                pe.setUsuario_pedido(p.getUsuario_pedido());

                return new ResponseEntity<>(pedidoService.save(pe), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Pedido> eliminarPedido(@PathVariable Integer id) {
        pedidoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
