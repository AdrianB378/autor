package com.todocodeacademy.autor.repository;

import com.todocodeacademy.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
 
    @Query("SELECT a FROM Autor a WHERE a.nombreCompleto = :nombreCompleto")
    public Autor findByNombreCompleto(String nombreCompleto);
}
