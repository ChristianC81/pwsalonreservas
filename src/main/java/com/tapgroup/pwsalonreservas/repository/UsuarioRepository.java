/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;



import com.tapgroup.pwsalonreservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
        @Query(value = "Select * from usuario u where u.nombre_usuario = :nombre_usuario", nativeQuery = true)
    public Usuario buscarUsuario(String nombre_usuario);
}
