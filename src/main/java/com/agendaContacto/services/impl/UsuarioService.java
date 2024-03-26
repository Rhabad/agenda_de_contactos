package com.agendaContacto.services.impl;

import com.agendaContacto.exceptions.ResourceNotFoundException;
import com.agendaContacto.models.dao.RolDao;
import com.agendaContacto.models.dao.UsuarioDao;
import com.agendaContacto.models.dto.LoginDto;
import com.agendaContacto.models.dto.RegisterDto;
import com.agendaContacto.models.entities.Rol;
import com.agendaContacto.models.entities.Usuario;
import com.agendaContacto.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterDto registrarUsuario(RegisterDto registerDto) {
        Rol rol = rolDao.findById(2)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rol", "id", "2")
                );

        Usuario usuario = Usuario.builder()
                .nombre(registerDto.getNombre())
                .username(registerDto.getUsername())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .rol(rol)
                .build();

        usuarioDao.save(usuario);

        return RegisterDto.builder()
                .nombre(usuario.getNombre())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .build();
    }

    @Override
    public LoginDto login(LoginDto loginDto) {
        return null;
    }
}
