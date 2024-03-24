package com.agendaContacto.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterDto {
    private String nombre;
    private String username;
    private String email;
    private String password;

}
