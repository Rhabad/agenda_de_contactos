package com.agendaContacto.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaDto {
    private Integer id;
    private String username;
    private String nombreCategoria;
}
