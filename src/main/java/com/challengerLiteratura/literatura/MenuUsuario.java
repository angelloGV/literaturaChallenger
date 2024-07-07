package com.challengerLiteratura.literatura;

import java.util.Scanner;

public class MenuUsuario {

    private int opcionMenu = -1;

    public int getOpcionMenu() {
        return opcionMenu;
    }

    private int condicionSalida = 1;
    void MenuUsuario(){}

    void mostrarMenu()
    {
        while(condicionSalida != 0)
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


        }
    }
}
