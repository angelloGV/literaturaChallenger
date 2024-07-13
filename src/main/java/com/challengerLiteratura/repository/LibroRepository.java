package com.challengerLiteratura.repository;
import com.challengerLiteratura.unidadData.Autor;
import com.challengerLiteratura.unidadData.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

    @Query("SELECT a FROM Autor a JOIN a.libro l")
    List<Autor> mostrarAutores();
}
