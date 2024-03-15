package com.agendaContacto.controllers;

import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.services.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactoController {
    @Autowired
    private IContactoService contactoService;

    @GetMapping("/contactos/{idUsuario}")
    public ResponseEntity<List<ContactoDto>> getAllContact(@PathVariable Long idUsuario){
        return new ResponseEntity<>(contactoService.findAllByIdUsuario(idUsuario), HttpStatus.OK);
    }
}
