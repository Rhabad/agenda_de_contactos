package com.agendaContacto.models.dto;

import com.agendaContacto.models.entities.Contacto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CategoriaYContactoDto {
    private Integer id;
    private String nombreCategoria;
    private List<Contacto> contactos = new ArrayList<>();
}
