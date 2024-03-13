package com.agendaContacto.services.impl;

import com.agendaContacto.exceptions.ResourceNotFoundException;
import com.agendaContacto.models.dao.CategoriaDao;
import com.agendaContacto.models.dao.ContactoDao;
import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.models.entities.Categoria;
import com.agendaContacto.models.entities.Contacto;
import com.agendaContacto.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private ContactoDao contactoDao;

    @Override
    public List<CategoriaYContactoDto> findAllCategoryAndContact() {
        List<Contacto> lista = (List<Contacto>) contactoDao.findAll();

        List<CategoriaYContactoDto> listaDTO = new ArrayList<>();
        for (Contacto contacto : lista) {
            ContactoDto contactoDto = ContactoDto.builder()
                    .telefono(contacto.getTelefono())
                    .nombre(contacto.getNombre())
                    .email(contacto.getEmail())
                    .descripcion(contacto.getDescripcion())
                    .build();

            listaDTO.add(
                    CategoriaYContactoDto.builder()
                            .id(contacto.getCategoria().getId())
                            .nombreCategoria(contacto.getCategoria().getNombreCategoria())
                            .contactos(contactoDto)
                            .build());
        }


        return listaDTO;
    }

    @Override
    public CategoriaDto saveCategory(CategoriaDto categoriaDto) {
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {

    }

    @Override
    public CategoriaDto upgradeCategory(Integer id, CategoriaDto categoriaDto) {
        return null;
    }
}
