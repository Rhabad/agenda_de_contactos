package com.agendaContacto.services;

import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;

import java.util.List;


public interface ICategoriaService {
    CategoriaYContactoDto findAllCategoryAndContact(String nombre, Long idUsuario);
    List<CategoriaYContactoDto> findAll(Long idUsuario);
    CategoriaDto saveCategory(CategoriaDto categoriaDto);
    void deleteCategory(Integer id);
    CategoriaDto upgradeCategory(Integer id, CategoriaDto categoriaDto);
}
