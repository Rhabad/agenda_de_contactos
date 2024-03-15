package com.agendaContacto.services;

import com.agendaContacto.models.dto.ContactoDto;

import java.util.List;

public interface IContactoService {
    List<ContactoDto> findAllByIdUsuario(Long idUsuario);
    ContactoDto createContact(Long idUsuario, ContactoDto contactoDto);
}
