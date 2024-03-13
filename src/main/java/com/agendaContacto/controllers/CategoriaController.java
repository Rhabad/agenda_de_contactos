package com.agendaContacto.controllers;

import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria/{nombre}")
    public ResponseEntity<CategoriaYContactoDto> getAll(@PathVariable String nombre){
        return ResponseEntity.ok(categoriaService.findAllCategoryAndContact(nombre));
    }
}
