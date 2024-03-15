package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Contacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactoDao extends CrudRepository<Contacto, Long> {

    @Query(value = "select * from contacto where id_categoria = :idCategoria and id_usuario = :idUsuario", nativeQuery = true)
    List<Contacto> findAllByIdCategoriaAndIdUsuario(Integer idCategoria, Long idUsuario);

    @Query(value = "select * from contacto where id_categoria = :idCategoria", nativeQuery = true)
    List<Contacto> findAllByIdCategoria(Integer idCategoria);

    @Query(value = "select * from contacto where id_usuario = :idUsuario", nativeQuery = true)
    List<Contacto> findAllByIdUsuario(Long idUsuario);
}
