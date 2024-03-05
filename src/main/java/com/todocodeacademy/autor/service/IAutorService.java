
package com.todocodeacademy.autor.service;
import com.todocodeacademy.autor.model.Autor;
import java.util.List;


public interface IAutorService {
    
    public List<Autor> getAutores();

    public String saveAutor(Autor autor );

    public String deleteAutor(Long id);

    public Autor findAutor(Long id);

    public String editAutor (Long id, Autor autor);
    
    public Autor findByNombreCompleto(String nombreCompleto);
    
   
    
    

    
    
    
    
}
