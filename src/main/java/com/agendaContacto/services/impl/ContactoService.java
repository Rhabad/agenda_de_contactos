package com.agendaContacto.services.impl;

import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.services.IContactoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService {
    @Override
    public List<ContactoDto> findAllByIdUsuario(Long idUsuario) {
        
        return null;
    }
}
