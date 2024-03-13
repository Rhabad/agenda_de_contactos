package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Contacto;
import org.springframework.data.repository.CrudRepository;

public interface ContactoDao extends CrudRepository<Contacto, Long> {
}
