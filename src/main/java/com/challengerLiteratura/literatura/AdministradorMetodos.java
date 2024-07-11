package com.challengerLiteratura.literatura;

import com.challengerLiteratura.literaturaAPI.consultaAPI;
import com.challengerLiteratura.unidadData.APIRespuesta;
import com.challengerLiteratura.unidadData.Conversor;
import com.challengerLiteratura.unidadData.DatosLibro;
import com.challengerLiteratura.unidadData.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdministradorMetodos {

    private List<Libro> libros = new ArrayList<>();
    private Conversor conversor = new Conversor();
    private consultaAPI consulta = new consultaAPI();

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

        String json = consulta.getDataAPI(tituloLibro);
        var result = conversor.obtenerDatos(json, APIRespuesta.class).results();

        Optional<DatosLibro> libroBusqueda = result.stream()
                       .filter(d -> d. titulo().toLowerCase().
                               contains(tituloLibro.toLowerCase())).findFirst();

        if(libroBusqueda.isPresent())
        {
            DatosLibro dataLibro = libroBusqueda.get();
            Optional<Libro> libro = dataLibro.autor().stream().
            map(t-> new Libro(dataLibro.titulo(),t.autor(),t.axoNacimiento(),
                    t.axoFallecimiento(),dataLibro.idioma())).findFirst();

            if(libro.isPresent())
            {
                System.out.println("Los datos del libro buscado son ... \n");
                Libro libroEncontrado = libro.get();
                System.out.println(libroEncontrado.toString());
            }
            else
            {
                System.out.println("Libro no seteado");
            }
        }
        else
        {
            System.out.println("Libro no encontrado");
        }





    }



}
