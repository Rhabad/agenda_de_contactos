package com.agendaContacto.services;

import com.agendaContacto.models.dto.RegisterDto;

public interface IUsuarioService {

    /**
     * registrar un usuario, mapeandolo con un dto
     * @param registerDto
     * @return
     */
    RegisterDto registrarUsuario(RegisterDto registerDto);


}
