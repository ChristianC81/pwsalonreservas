/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tapgroup.pwsalonreservas.repository;

import com.tapgroup.pwsalonreservas.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author chris
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    //!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!
    //al mandar un parametro siempre va los :varible 
    //los : y la variable si no no vale
    
    //buscar el si existe un usuario 
    @Query ("SELECT COUNT(u)>0 FROM Usuario u WHERE u.usuNombre = :usuario")
    boolean validarUsuario(@Param("usuario")String usuNombre);
    
    //iniciar sesión
    @Query("SELECT u From Usuario u Where u.usuNombre = :usuario AND u.usuEstado=true")
    Optional<Usuario> findByUsuario(@Param("usuario") String usuNombre);
    
}
