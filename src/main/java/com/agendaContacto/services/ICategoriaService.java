package com.agendaContacto.services;

import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaYContactoDto> findAllCategoryAndContact();
    CategoriaDto saveCategory(CategoriaDto categoriaDto);
    void deleteCategory(Integer id);
    CategoriaDto upgradeCategory(Integer id, CategoriaDto categoriaDto);
}
