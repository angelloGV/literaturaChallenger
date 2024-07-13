package com.challengerLiteratura.literatura;

import com.challengerLiteratura.repository.LibroRepository;
import com.challengerLiteratura.literaturaAPI.consultaAPI;
import com.challengerLiteratura.unidadData.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdministradorMetodos {

    private List<Libro> libros = new ArrayList<>();
    private Conversor conversor = new Conversor();
    private consultaAPI consulta = new consultaAPI();
    private LibroRepository libroRepository;
    private int condicionSalida = 1;
    private int opcionMenu = -1;

    Scanner scanner = new Scanner(System.in);

    private String tituloLibro;
    private int caso = -1;

    public AdministradorMetodos() {}

    public AdministradorMetodos(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void mostrarMenu()
    {
        while(condicionSalida != 0) {
            var menu = """
                    1- buscar libro por titulo
                    2- listar libros registrados
                    3- listar autores registrados
                    4- listar autores vivos en un determinado año
                    5- listar libros por idioma
                    0- salir
                    """;
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            boolean esEntero = scanner.hasNextInt();
            if (esEntero) {
                opcionMenu = scanner.nextInt();
                if ((opcionMenu >= 0) && (opcionMenu <= 5)) {
                    condicionSalida = 0;
                } else {
                    System.out.println("Intentelo de nuevo");
                    opcionMenu = -1;
                }
            } else {
                System.out.println("Intentelo de nuevo");
            }
        }

        switch (opcionMenu)
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
            DatosAutor datosAutor = dataLibro.autor().get(0);
            Autor autor = new Autor(datosAutor);
            Libro libroActual = new Libro(dataLibro);
            System.out.println(libroActual.toString());
            //System.out.println(autor.toString());

            //SAVE BOOK SAVE AUTOR
            libroRepository.save(libroActual);
        }
        else
        {
            System.out.println("Libro no encontrado");
        }
    }



}
