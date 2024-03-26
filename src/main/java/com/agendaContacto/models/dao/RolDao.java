package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDao extends CrudRepository<Rol, Integer> {
}
