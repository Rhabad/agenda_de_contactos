package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Categoria;
import com.agendaContacto.models.entities.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer> {
}
