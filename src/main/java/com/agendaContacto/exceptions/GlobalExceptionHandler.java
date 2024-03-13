package com.agendaContacto.exceptions;

import com.agendaContacto.models.dto.ErrorDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalles> manejarRecourceNotFoundException(
        ResourceNotFoundException exception,
        WebRequest webRequest
    ){
        ErrorDetalles errorDetalles = ErrorDetalles.builder()
                .marcaDeTiempo(new Date())
                .mensaje(exception.getMessage())
                .error(webRequest.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }
}
