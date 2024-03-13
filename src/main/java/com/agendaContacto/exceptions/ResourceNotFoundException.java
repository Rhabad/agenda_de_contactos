package com.agendaContacto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private  static final long serialVersionUID = 1L;

    private String nombreResource;
    private String nombreCampo;
    private String valorCampo;

    public ResourceNotFoundException(String nombreResource, String nombreCampo, String valorCampo) {
        super(String.format(nombreResource+" no ENCONTRADO con : "+nombreCampo+" : "+valorCampo));
        this.nombreResource = nombreResource;
        this.nombreCampo = nombreCampo;
        this.valorCampo = valorCampo;
    }

    public String getNombreResource() {
        return nombreResource;
    }

    public void setNombreResource(String nombreResource) {
        this.nombreResource = nombreResource;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getValorCampo() {
        return valorCampo;
    }

    public void setValorCampo(String valorCampo) {
        this.valorCampo = valorCampo;
    }
}
