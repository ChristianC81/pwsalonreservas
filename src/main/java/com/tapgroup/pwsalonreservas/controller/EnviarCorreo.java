/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnviarCorreo {

    @Autowired
    private JavaMailSender mail;
    
    //? = enviar cualquier tipo de dato
    @PostMapping("enviar")
    public ResponseEntity<?> enviarCorreo(){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("ejemplo@gmail.com");
        email.setFrom("cuyrent@gmail.com");
        email.setSubject("Mensaje de prueba1");
        email.setText("El cuerpo del mesaje");
        //
        mail.send(email);
        
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    
    

}
