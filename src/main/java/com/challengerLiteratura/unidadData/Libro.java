package com.challengerLiteratura.unidadData;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo ="";

    private String autor = "";
    private List<String> idioma = new ArrayList<>();

    public Libro(){}
    public Libro(DatosLibro dataLibro)
    {
        this.titulo = dataLibro.titulo();
        this.autor = dataLibro.autor().get(0).autor();
        this.idioma = dataLibro.idioma();
    }

    @Override
    public String toString() {
        /*StringBuilder result = new StringBuilder();
        StringBuilder lenguajeFull = new StringBuilder();

        for(String currentLenguaje : idioma)
        {
            lenguajeFull.append(currentLenguaje);
        }
        String resultIdioma = lenguajeFull.toString();

        result.append("The data of the searched book is: ").append("\n");
        result.append("Title: ").append(titulo).append("\n");
        result.append("Authors: ").append(autor).append("\n");
        result.append("Language: ").append(resultIdioma).append("\n");
        return result.toString();*/
        return "";
    }
}
