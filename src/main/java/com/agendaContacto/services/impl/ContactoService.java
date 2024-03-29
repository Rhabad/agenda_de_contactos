package com.agendaContacto.services.impl;

import com.agendaContacto.models.dao.ContactoDao;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.models.entities.Contacto;
import com.agendaContacto.services.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoDao contactoDao;

    /**
     * listar todos los contactos de ese usuario
     * @param idUsuario
     * @return
     */
    @Override
    public List<ContactoDto> findAllByIdUsuario(Long idUsuario) {
        List<Contacto> contactoList = contactoDao.findAllByIdUsuario(idUsuario);

        List<ContactoDto> contactoDtoList = new ArrayList<>();
        for (Contacto contacto: contactoList){
            contactoDtoList.add(ContactoDto.builder()
                            .telefono(contacto.getTelefono())
                            .nombre(contacto.getNombre())
                            .descripcion(contacto.getDescripcion())
                            .email(contacto.getEmail())
                    .build());
        }
        return contactoDtoList;
    }
}
