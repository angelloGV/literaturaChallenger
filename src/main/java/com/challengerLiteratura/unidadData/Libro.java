package com.challengerLiteratura.unidadData;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {

    private String titulo ="";
    private List<String> autor = new ArrayList<>();
    private int axoNacimiento = -1;
    private int axoFallecimiento = -1;
    private List<String> idioma = new ArrayList<>();

    public Libro(){}

    public Libro(String titulo, List<String> autor,
            int axoNAcimiento, int axoFAllecimiento ,
                 List<String> idioma)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.axoNacimiento = axoNacimiento;
        this.axoFallecimiento = axoFallecimiento;
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        StringBuilder autorFull = new StringBuilder();
        for(String currentAutor : autor)
        {
            autorFull.append(currentAutor);
        }
        String resultAutor = autorFull.toString();

        StringBuilder lenguajeFull = new StringBuilder();
        for(String currentLenguaje : idioma)
        {
            lenguajeFull.append(currentLenguaje);
        }
        String resultIdioma = lenguajeFull.toString();

        result.append("The book searched for is:\n");
        result.append("Title: ").append(titulo).append("\n");
        result.append("Authors: ").append(resultAutor).append("\n");
        result.append("Year of Birth of the Author: ").append(axoNacimiento).append("\n");
        result.append("Year of Death of the Author: ").append(axoFallecimiento).append("\n");
        result.append("Language: ").append(resultIdioma).append("\n");
        return result.toString();
    }
}
