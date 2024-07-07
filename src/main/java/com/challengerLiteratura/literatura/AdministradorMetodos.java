package com.challengerLiteratura.literatura;

import com.challengerLiteratura.unidadData.Libro;

import java.util.ArrayList;
import java.util.List;

public class AdministradorMetodos {

    private List<Libro> libros = new ArrayList<>();

    public AdministradorMetodos() {}

    public AdministradorMetodos(int value)
    {
        switch (value)
        {
            case 1:
                buscarLibroPorTitulo();
                break;

            case 2:
                //listarLibrosRegistrados();
                break;

            case 3:
                //listarAutoresRegistrados();
                break;

            case 4:
                //listarAutoresVivosEnAñoDeterminado();
                break;

            case 5:
                //listarLibrosPorIdioma();
                break;
            case 0:
                System.out.println("Cerrando la Aplicacion");
                break;
            default:
                System.out.println("Opcion Invalida, intente nuevamente");

        }
    }

    Libro buscarLibroPorTitulo()
    {
        Libro libro = new Libro();
        return libro;
    }


}
