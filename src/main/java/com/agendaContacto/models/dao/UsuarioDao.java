package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
}
