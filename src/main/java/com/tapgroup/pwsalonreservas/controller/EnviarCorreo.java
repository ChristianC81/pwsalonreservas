/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tapgroup.pwsalonreservas.controller;

import com.tapgroup.pwsalonreservas.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EnviarCorreo {

    @Autowired
    private JavaMailSender mail;
    
    //? = enviar cualquier tipo de dato
    @PostMapping("/enviar")
    public ResponseEntity<?> enviarCorreo(@RequestBody Email e){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(e.getTo());
        email.setFrom("cuyrent@gmail.com");
        email.setSubject(e.getSubject());
        email.setText(e.getText());
        //
        mail.send(email);
        
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    
    

}
