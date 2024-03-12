package com.agendaContacto.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre_categoria"})
})
@Data @AllArgsConstructor @NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria", orphanRemoval = true)
    private List<Contacto> contactos = new ArrayList<>();
}
