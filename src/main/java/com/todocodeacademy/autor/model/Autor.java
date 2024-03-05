package com.todocodeacademy.autor.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> listaLibros;

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<String> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<String> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + ", listaLibros=" + listaLibros + '}';
    }
    
    
    
    
}
