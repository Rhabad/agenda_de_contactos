package com.agendaContacto.services;

import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;

import java.util.List;


public interface ICategoriaService {
    CategoriaYContactoDto findAllCategoryAndContact(String nombre);
    List<CategoriaDto> findAll();
    CategoriaDto saveCategory(CategoriaDto categoriaDto);
    void deleteCategory(Integer id);
    CategoriaDto upgradeCategory(Integer id, CategoriaDto categoriaDto);
}
