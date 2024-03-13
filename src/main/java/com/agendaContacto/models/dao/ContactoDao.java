package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Contacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactoDao extends CrudRepository<Contacto, Long> {

    @Query(value = "select * from contacto where id_categoria = :idCategoria", nativeQuery = true)
    List<Contacto> findAllByIdCategoria(Integer idCategoria);
}
