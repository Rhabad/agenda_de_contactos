package com.agendaContacto.services.impl;

import com.agendaContacto.exceptions.ResourceNotFoundException;
import com.agendaContacto.models.dao.CategoriaDao;
import com.agendaContacto.models.dao.ContactoDao;
import com.agendaContacto.models.dao.LoginDao;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.models.entities.Categoria;
import com.agendaContacto.models.entities.Contacto;
import com.agendaContacto.models.entities.Usuario;
import com.agendaContacto.services.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoDao contactoDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private CategoriaDao categoriaDao;

    /**
     * listar todos los contactos de ese usuario
     *
     * @param idUsuario
     * @return
     */
    @Override
    public List<ContactoDto> findAllByIdUsuario(Long idUsuario) {
        List<Contacto> contactoList = contactoDao.findAllByIdUsuario(idUsuario);

        List<ContactoDto> contactoDtoList = new ArrayList<>();
        for (Contacto contacto : contactoList) {
            contactoDtoList.add(ContactoDto.builder()
                    .telefono(contacto.getTelefono())
                    .nombre(contacto.getNombre())
                    .descripcion(contacto.getDescripcion())
                    .email(contacto.getEmail())
                    .build());
        }
        return contactoDtoList;
    }

    /**
     * creamos un nuevo contacto asociado al usuario.
     *
     * @param idUsuario
     * @param contactoDto
     * @return
     */
    @Override
    public ContactoDto createContact(Long idUsuario, ContactoDto contactoDto) {
        Usuario usuario = loginDao.findById(idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario", "id", idUsuario.toString())
                );

        Contacto contacto = Contacto.builder()
                .telefono(contactoDto.getTelefono())
                .nombre(contactoDto.getNombre())
                .descripcion(contactoDto.getDescripcion())
                .email(contactoDto.getEmail())
                .usuario(usuario)
                .build();
        contactoDao.save(contacto);

        return ContactoDto.builder()
                .telefono(contacto.getTelefono())
                .nombre(contacto.getNombre())
                .descripcion(contacto.getDescripcion())
                .email(contacto.getEmail())
                .build();
    }

    /**
     * actualizamos el contacto.
     *
     * @param id          para buscar el contacto
     * @param contactoDto el cuerpo necesario para cambiar los datos anteriores
     * @return retorna el dto, como muestra.
     */
    @Override
    public ContactoDto updateContact(Long id, ContactoDto contactoDto) {
        Contacto contacto = contactoDao.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contacto", "id", id.toString())
                );
        contacto.setTelefono(contactoDto.getTelefono());
        contacto.setNombre(contactoDto.getNombre());
        contacto.setDescripcion(contactoDto.getDescripcion());
        contacto.setEmail(contactoDto.getEmail());

        contactoDao.save(contacto);

        return ContactoDto.builder()
                .email(contacto.getEmail())
                .descripcion(contacto.getDescripcion())
                .nombre(contacto.getNombre())
                .telefono(contacto.getTelefono())
                .build();
    }

    /**
     * @param id              buscamos el contacto
     * @param nombreCategoria cambiamos de categoria por su nombre.
     * @return retorna mensaje del cambio
     */
    @Override
    public String cambiarCategoriaDelContacto(Long id, String nombreCategoria) {
        Contacto contacto = contactoDao.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contacto", "id", id.toString())
                );

        String anteriorCategoria;
        String cambioCategoria;
        if (contacto.getCategoria() == null || contacto.getCategoria().getNombreCategoria().isEmpty()) {
            anteriorCategoria = "No tiene categoria";
        } else {
            anteriorCategoria = contacto.getCategoria().getNombreCategoria();
        }


        //buscmos esa categoria por el idusuario y el nombre categoria.

        Categoria categoria = categoriaDao.findByNombreAndIdUsuario(nombreCategoria, contacto.getUsuario().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException
                                ("Categoria", "nombre_categoria - id_usuario",
                                        nombreCategoria + " - " + contacto.getUsuario().getId())
                );

        contacto.setCategoria(categoria);

        cambioCategoria = contacto.getCategoria().getNombreCategoria();

        contactoDao.save(contacto);

        return "Contacto con categoria: " + anteriorCategoria + " fue cambiado a: " + cambioCategoria;
    }

    @Override
    public void deleteContact(Long id) {
        Contacto contacto = contactoDao.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contacto", "id", id.toString())
                );
        contactoDao.delete(contacto);
    }
}
