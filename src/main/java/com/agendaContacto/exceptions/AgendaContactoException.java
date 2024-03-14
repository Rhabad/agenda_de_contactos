package com.agendaContacto.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Data
public class AgendaContactoException extends RuntimeException{
    @Serial
    private  static final long serialVersionUID = 1L;

    private HttpStatus client;
    private String mensaje;

    public AgendaContactoException(HttpStatus client, String mensaje) {
        super();
        this.client = client;
        this.mensaje = mensaje;
    }
}
