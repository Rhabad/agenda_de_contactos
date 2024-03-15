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

    @PutMapping("/contacto/{id}")
    public ResponseEntity<ContactoDto> updateContact(
            @PathVariable Long id,
            @RequestBody ContactoDto contactoDto
    ) {
        return new ResponseEntity<>(contactoService.updateContact(id, contactoDto), HttpStatus.OK);
    }

    @PatchMapping("/contacto/{id}/{nombreCategoriaACambia}")
    public ResponseEntity<String> cambiarCategoria(
            @PathVariable Long id,
            @PathVariable String nombreCategoriaACambia
    ) {
        return new ResponseEntity<>(contactoService.cambiarCategoriaDelContacto
                (id, nombreCategoriaACambia), HttpStatus.OK);
    }

    @DeleteMapping("/contacto/{id}")
    public ResponseEntity<String> deleteContact(
            @PathVariable Long id
    ) {
        contactoService.deleteContact(id);
        return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);
    }

}
