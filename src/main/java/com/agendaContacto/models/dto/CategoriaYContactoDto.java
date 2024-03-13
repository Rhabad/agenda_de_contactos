package com.agendaContacto.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoriaYContactoDto {
    private Integer id;
    private String nombreCategoria;
    private ContactoDto contactos;
}
