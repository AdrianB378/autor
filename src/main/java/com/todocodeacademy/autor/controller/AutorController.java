package com.todocodeacademy.autor.controller;

import com.todocodeacademy.autor.model.Autor;
import com.todocodeacademy.autor.service.IAutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private IAutorService autorServ;
    
    
    
    @GetMapping("/traer")
    public List<Autor>obtenerAutores() {
        return autorServ.getAutores();

}
            
    @PostMapping ("/crear")
    public String crearAutor(@RequestBody Autor autor) {
        autorServ.saveAutor(autor);
        return "El autor se ha creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String borrarAutor(@PathVariable Long id) {
        autorServ.deleteAutor(id);
        return "El autor se ha eliminado correctamente";
    }
    
    @GetMapping("/traer/{id}") 
    public Autor obtenerAutor(@PathVariable Long id) {
        return autorServ.findAutor(id);
    }
    
    @PutMapping("/editar/{id}")
     public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor aut) {
        Autor autorExistente = autorServ.findAutor(id);

        if (autorExistente == null) {
            return new ResponseEntity<>("Autor no encontrado", HttpStatus.NOT_FOUND);
        }

        autorExistente.setNombreCompleto(aut.getNombreCompleto());
        autorExistente.setFechaNacimiento(aut.getFechaNacimiento());

        autorServ.editAutor(id, autorExistente);

        return new ResponseEntity<>("Autor actualizado correctamente", HttpStatus.OK);
    }
    
    @GetMapping("/traernombre/{nombreCompleto}")
        public Autor findByNombreCompleto (@PathVariable String nombreCompleto) {
             return autorServ.findByNombreCompleto(nombreCompleto);
        }
 
}    
   
    
    
    
    
    

