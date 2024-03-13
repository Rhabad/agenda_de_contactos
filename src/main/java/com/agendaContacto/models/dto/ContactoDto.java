package com.agendaContacto.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactoDto {
    private String telefono;
    private String nombre;
    private String descripcion;
    private String email;
}
