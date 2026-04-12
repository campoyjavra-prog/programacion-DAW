package com.example.demo.controller;

import com.example.demo.modelo.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController()
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    ProductoService service;
    
    //Constructor de la clase para inyectar el servicio
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = service.crear(producto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    // READ - listar todos
    @GetMapping
    public ArrayList<Producto> listar() {
        return service.listar();
    }

    // READ - buscar por id
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable int id,
            @RequestBody Producto producto) {
        return service.actualizar(id, producto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminar(id);
    }
}
