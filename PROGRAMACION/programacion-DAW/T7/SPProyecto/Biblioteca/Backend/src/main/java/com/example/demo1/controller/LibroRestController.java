package com.example.demo1.controller;

import com.example.demo1.model.Libro;
import com.example.demo1.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:5173")
public class LibroRestController {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroRestController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Listar todos los libros
    @GetMapping
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    // Guardar un nuevo libro
    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }

    // Buscar por título
    @GetMapping("/titulo/{titulo}")
    public List<Libro> buscarPorTitulo(@PathVariable String titulo) {
        return libroRepository.findByTituloIgnoreCase(titulo);
    }

    // Buscar por autor
    @GetMapping("/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor) {
        return libroRepository.findByAutorIgnoreCase(autor);
    }

    // Buscar por rango de años
    @GetMapping("/anio/{min}/{max}")
    public List<Libro> buscarPorRangoDeAnios(@PathVariable int min, @PathVariable int max) {
        return libroRepository.findByAnioBetween(min, max);
    }

    // Endpoint para obtener un libro por su ID (GET)
    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }

    // Endpoint para actualizar un libro existente (PUT)
    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setAnio(libroActualizado.getAnio());
            libro.setImagen(libroActualizado.getImagen());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }
}
