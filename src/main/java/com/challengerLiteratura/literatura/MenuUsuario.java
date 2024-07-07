package com.challengerLiteratura.literatura;

import java.util.Scanner;

public class MenuUsuario {

    private int opcionMenu = -1;
    private int opcion = 1;
    void MenuUsuario(){}

    void mostrarMenu()
    {
        while(opcion != 0)
        {
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
            if(esEntero)
            {   opcionMenu = scanner.nextInt();
            }
            else
            {
                System.out.println("Intentelo de nuevo");
            }
            switch (opcionMenu)
            {
                case 1:
                    //buscarLibroPorTitulo();
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
                    opcion=0;
                    break;
                default:
                    System.out.println("Opcion Invalida, intente nuevamente");

            }
        }



    }


}
