package com.challengerLiteratura.literatura;

import com.challengerLiteratura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

    @Autowired
    private LibroRepository libroRepository;

	public static void main(String[] args) {
            SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AdministradorMetodos adm = new AdministradorMetodos(libroRepository);
        adm.mostrarMenu();
    }

}
