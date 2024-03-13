package com.agendaContacto.models.dto;

import lombok.Data;

@Data
public class ContactoDto {
    private String telefono;
    private String nombre;
    private String descripcion;
    private String email;
}
