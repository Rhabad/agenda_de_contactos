package com.agendaContacto.controllers;

import com.agendaContacto.models.dto.RegisterDto;
import com.agendaContacto.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("register")
    public ResponseEntity<RegisterDto> registrar(@RequestBody RegisterDto registerDto){
        return new ResponseEntity<>(usuarioService.registrarUsuario(registerDto), HttpStatus.CREATED);
    }
}
