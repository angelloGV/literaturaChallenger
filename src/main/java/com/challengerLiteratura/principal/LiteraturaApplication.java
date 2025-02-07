package com.challengerLiteratura.principal;

import com.challengerLiteratura.literatura.AdministradorMetodos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
    @Autowired
    LibroRepository libroRefactory;

    @Autowired
    AutorRepository autorRefactory;


    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApplication.class, args);
    }

   @Override
    public void run(String... args) throws Exception {
        AdministradorMetodos amd = new AdministradorMetodos(libroRefactory,
                autorRefactory);
    }
}