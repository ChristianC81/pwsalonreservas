/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;


import com.tapgroup.pwsalonreservas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
        @Query(value = "Select * from pedido u where u.id_pedido = :id_pedido", nativeQuery = true)
    public Pedido buscarPedido(int id_pedido);
}
