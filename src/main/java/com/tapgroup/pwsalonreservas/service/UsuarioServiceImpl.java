/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.service;


import com.tapgroup.pwsalonreservas.model.Usuario;
import com.tapgroup.pwsalonreservas.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements GenericService<Usuario, Integer> {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean validarUsuario(String usuNombre) {
        return usuarioRepository.validarUsuario(usuNombre);
    }

    public List usuariosActivos(){
        return usuarioRepository.getUsuariosActivos();
    }
    
    public List usuariosInactivos(){
        return usuarioRepository.getUsuariosInactivos();
    }
    
    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }


}

