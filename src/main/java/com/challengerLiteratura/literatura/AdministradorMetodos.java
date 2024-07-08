package com.challengerLiteratura.literatura;

import com.challengerLiteratura.literaturaAPI.consultaAPI;
import com.challengerLiteratura.unidadData.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorMetodos {

    private List<Libro> libros = new ArrayList<>();
    consultaAPI consulta = new consultaAPI();

    Scanner scanner = new Scanner(System.in);

    private String tituloLibro;
    private int caso = -1;
    public AdministradorMetodos() {}

    public AdministradorMetodos(int value)
    {
        caso = value;
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

    void buscarLibroPorTitulo( )
    {
        int validar = 1;
        while(validar == 1)
        {
            System.out.println("Ingrese el titulo del libro en ingles");
            if (scanner.hasNextLine())
            {
                tituloLibro = scanner.nextLine();
                validar = 0;
            }
            else
            {
                System.out.println("Intente digitar nuevamente el titulo del libro en ingles");
            }
        }


        Libro libro = new Libro();
        String result = consulta.getDataAPI(tituloLibro);
        System.out.println(result);
    }



}
