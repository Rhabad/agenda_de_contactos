package com.agendaContacto.controllers;

import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.services.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactoController {
    @Autowired
    private IContactoService contactoService;

    @GetMapping("/contactos/{idUsuario}")
    public ResponseEntity<List<ContactoDto>> getAllContact(@PathVariable Long idUsuario) {
        return new ResponseEntity<>(contactoService.findAllByIdUsuario(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/contacto/{idUsuario}")
    public ResponseEntity<ContactoDto> createContact(
            @PathVariable Long idUsuario,
            @RequestBody ContactoDto contactoDto
    ) {
        return new ResponseEntity<>(contactoService.createContact(idUsuario, contactoDto), HttpStatus.CREATED);
    }
}
