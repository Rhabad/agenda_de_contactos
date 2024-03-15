package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<Usuario, Long>  {
}
