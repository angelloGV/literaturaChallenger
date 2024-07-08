package com.challengerLiteratura.literatura;

import com.challengerLiteratura.literaturaAPI.consultaAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {

        MenuUsuario menu = new MenuUsuario();
        menu.mostrarMenu();
        var opcionEscogida = menu.getOpcionMenu();
        AdministradorMetodos adm = new AdministradorMetodos(opcionEscogida);


    }

}
