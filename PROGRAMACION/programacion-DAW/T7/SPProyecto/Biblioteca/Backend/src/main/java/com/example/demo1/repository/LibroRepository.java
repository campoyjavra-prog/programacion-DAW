package com.example.demo1.repository;

import com.example.demo1.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar por título ignorando mayúsculas
    List<Libro> findByTituloIgnoreCase(String titulo);

    // Buscar por autor ignorando mayúsculas
    List<Libro> findByAutorIgnoreCase(String autor);

    // Buscar libros entre dos años determinados
    List<Libro> findByAnioBetween(int anioMin, int anioMax);
}
