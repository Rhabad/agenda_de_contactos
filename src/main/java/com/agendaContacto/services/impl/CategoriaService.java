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
    public CategoriaYContactoDto findAllCategoryAndContact(String nombre) {
        Categoria categoria = categoriaDao.findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria", "nombre_categoria", nombre)
                );

        List<Contacto> listaContactos = contactoDao.findAllByIdCategoria(categoria.getId());

        List<ContactoDto> contactoDtoList = new ArrayList<>();
        for (Contacto contact : listaContactos) {
            contactoDtoList.add(ContactoDto.builder()
                    .telefono(contact.getTelefono())
                    .nombre(contact.getNombre())
                    .email(contact.getEmail())
                    .descripcion(contact.getDescripcion())
                    .build());
        }

        CategoriaYContactoDto categoriaYContactoDto = CategoriaYContactoDto.builder()
                .id(categoria.getId())
                .nombreCategoria(categoria.getNombreCategoria())
                .contactos(contactoDtoList)
                .build();

        return categoriaYContactoDto;
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
