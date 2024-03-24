package com.agendaContacto.services.impl;

import com.agendaContacto.models.dao.UsuarioDao;
import com.agendaContacto.models.dto.RegisterDto;
import com.agendaContacto.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public RegisterDto registrarUsuario(RegisterDto registerDto) {
        return null;
    }
}
