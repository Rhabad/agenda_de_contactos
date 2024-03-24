package com.agendaContacto.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rol;
    @Column(name = "nombre_rol", length = 60)
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios = new ArrayList<>();
}
