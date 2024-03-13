package com.agendaContacto.models.dao;

import com.agendaContacto.models.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer> {
    @Query(value = "select * from categoria where nombre_categoria = :nombreCategoria", nativeQuery = true)
    Optional<Categoria> findByNombre(String nombreCategoria);

}
