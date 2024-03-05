package com.todocodeacademy.autor.service;

import com.todocodeacademy.autor.model.Autor;
import com.todocodeacademy.autor.repository.IAutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private IAutorRepository autorRepo;

    @Override
    public List<Autor> getAutores() {

        return autorRepo.findAll();

    }

    @Override
    public String saveAutor(Autor autor) {
     

        autorRepo.save(autor);

        return "El Autor se ha creado correctamente";
   
    }

    @Override
    public String deleteAutor(Long id) {
        autorRepo.deleteById(id);
        return "El autor se ha eliminado correctamente";
    }

    @Override
    public Autor findAutor(Long id) {
        return (Autor) autorRepo.findById(id).orElse(null);

    }

    @Override
    public String editAutor(Long id, Autor autor) {
        Autor aut = this.findAutor(id);
        autor.setNombreCompleto(autor.getNombreCompleto());
        autor.setFechaNacimiento(autor.getFechaNacimiento());

        autorRepo.save(autor);
        return "El autor se ha editado correctamente";
    }

    @Override
    public Autor findByNombreCompleto(String nombreCompleto) {
        return autorRepo.findByNombreCompleto(nombreCompleto);
    }

}
