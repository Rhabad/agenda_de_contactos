package com.agendaContacto.services.impl;

import com.agendaContacto.exceptions.ResourceNotFoundException;
import com.agendaContacto.models.dao.CategoriaDao;
import com.agendaContacto.models.dao.ContactoDao;
import com.agendaContacto.models.dto.CategoriaDto;
import com.agendaContacto.models.dto.CategoriaYContactoDto;
import com.agendaContacto.models.dto.ContactoDto;
import com.agendaContacto.models.entities.Categoria;
import com.agendaContacto.models.entities.Contacto;
import com.agendaContacto.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private ContactoDao contactoDao;

    /**
     * Mostramos por id de usuario y nombre de categoria.
     *
     * @param nombre
     * @param idUsuario
     * @return retorna un dto que muestra nombre de usuario, la categoria y los contactos.
     */
    @Override
    public CategoriaYContactoDto findAllCategoryAndContact(String nombre, Long idUsuario) {
        Categoria categoria = categoriaDao.findByNombreAndIdUsuario(nombre, idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria", "nombre_categoria", nombre)
                );

        List<Contacto> listaContactos = contactoDao
                .findAllByIdCategoriaAndIdUsuario(categoria.getId(), idUsuario);

        List<ContactoDto> contactoDtoList = new ArrayList<>();
        for (Contacto contact : listaContactos) {
            contactoDtoList.add(ContactoDto.builder()
                    .telefono(contact.getTelefono())
                    .nombre(contact.getNombre())
                    .email(contact.getEmail())
                    .descripcion(contact.getDescripcion())
                    .build());
        }

        CategoriaYContactoDto categoriaYContactoDto = CategoriaYContactoDto.builder()
                .id(categoria.getId())
                .username(categoria.getUsuario().getUsername())
                .nombreCategoria(categoria.getNombreCategoria())
                .contactos(contactoDtoList)
                .build();

        return categoriaYContactoDto;
    }


    /**
     * muestra todas las categorias y sus contactos asociadas a un usuario
     *
     * @return
     */
    @Override
    public List<CategoriaYContactoDto> findAll(Long idUsuario) {
        //arreglar esto, esta malito, se dublica los contactos
        List<Categoria> listaCategorias = categoriaDao.findByIdUsuario(idUsuario);

        List<CategoriaYContactoDto> catAndCont = new ArrayList<>();

        // recorremos lista categoria
        for (Categoria cate : listaCategorias) {
            List<ContactoDto> dtoContactos = new ArrayList<>();

            // encontramos los contactos de esa categoria
            List<Contacto> listaContactos = contactoDao
                    .findAllByIdCategoriaAndIdUsuario(cate.getId(), idUsuario);

            // recorremos lista de contactos
            for (Contacto contacto : listaContactos) {
                dtoContactos.add(ContactoDto.builder()
                        .telefono(contacto.getTelefono())
                        .nombre(contacto.getNombre())
                        .email(contacto.getEmail())
                        .descripcion(contacto.getDescripcion())
                        .build());
            }
            // buildeamos al dto
            CategoriaYContactoDto categoriaYContactoDto = CategoriaYContactoDto.builder()
                    .id(cate.getId())
                    .username(cate.getUsuario().getUsername())
                    .nombreCategoria(cate.getNombreCategoria())
                    .contactos(dtoContactos)
                    .build();

            //le agregamos a lista de dto's
            catAndCont.add(categoriaYContactoDto);
        }

        return catAndCont;
    }

    /**
     * guardamos la nueva categoria en la base de datos
     *
     * @param categoriaDto
     * @return retornamos un dto mostrando lo guardado.
     */
    @Override
    public CategoriaDto saveCategory(CategoriaDto categoriaDto) {
        Categoria categoria = Categoria.builder()
                .nombreCategoria(categoriaDto.getNombreCategoria())
                .build();
        categoriaDao.save(categoria);

        return CategoriaDto.builder()
                .nombreCategoria(categoria.getNombreCategoria())
                .build();
    }

    /**
     * eliminamos la categoria, teniendo en cuenta que al borrarlo
     * no se debe borrar los contactos asociados.
     *
     * @param id
     */
    @Override
    public void deleteCategory(Integer id) {
        // buscamos todos los contactos relacionados a ese contacto.
        List<Contacto> listaContactos = contactoDao.findAllByIdCategoria(id);

        // eliminamos la categoria de cada contacto.
        for (Contacto contacto : listaContactos) {
            contacto.setCategoria(null);
            contactoDao.save(contacto);
        }

        categoriaDao.deleteById(id);

    }


    /**
     * buscamos categoria por el id, luego cambiamos su nombre y
     * por ultimo lo guardamos
     *
     * @param id
     * @param categoriaDto
     * @return se retorna un dto de los cambios.
     */
    @Override
    public CategoriaDto upgradeCategory(Integer id, CategoriaDto categoriaDto) {
        Categoria categoria = categoriaDao.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria", "id", id.toString())
                );
        categoria.setNombreCategoria(categoriaDto.getNombreCategoria());

        Categoria categoriaActualizada = categoriaDao.save(categoria);

        return CategoriaDto.builder()
                .id(categoriaActualizada.getId())
                .nombreCategoria(categoriaActualizada.getNombreCategoria())
                .build();
    }
}
