package com.agendaContacto.controllers;

import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria/{idUsuario}/{nombreCategoria}")
    public ResponseEntity<CategoriaYContactoDto> getAllCategoryAndContact(
            @PathVariable String nombreCategoria,
            @PathVariable Long idUsuario
    ){
        return ResponseEntity.ok(categoriaService.findAllCategoryAndContact(nombreCategoria, idUsuario));
    }
    @GetMapping("/categorias/{idUsuario}")
    public ResponseEntity<List<CategoriaYContactoDto>> getAll(@PathVariable Long idUsuario){
        return new ResponseEntity<>(categoriaService.findAll(idUsuario), HttpStatus.OK);
    }


    @PostMapping("/categoria")
    public ResponseEntity<CategoriaDto> createCategory(
            @RequestBody CategoriaDto categoriaDto
    ){
        return new ResponseEntity<>(categoriaService.saveCategory(categoriaDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id){
        categoriaService.deleteCategory(id);
        return new ResponseEntity<>("Categoria eliminada con exito", HttpStatus.OK);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaDto> upgradeCategory(
            @PathVariable Integer id, @RequestBody CategoriaDto categoriaDto) {
        return new ResponseEntity<>(categoriaService.upgradeCategory(id, categoriaDto), HttpStatus.OK);
    }
}
