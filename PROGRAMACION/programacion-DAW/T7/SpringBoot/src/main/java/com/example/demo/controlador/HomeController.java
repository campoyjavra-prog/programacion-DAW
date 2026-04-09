package com.example.demo.controlador;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/test-home")
    public String home(Model model) {
        model.addAttribute("mensaje", "Hola desde Spring Boot");
        model.addAttribute("nombres", List.of("Ana", "Luis", "Maria"));
        model.addAttribute("edad", 25);
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }

    // Ruta especifica
    @GetMapping("/ciclos/nuevo")
    public String ciclo(Model model) {
        model.addAttribute("ciclo", "nuevo");
        return "ciclo";
    }

    // Ruta Dinamica general
    @GetMapping("/ciclos/{id}")
    public String ciclo(@PathVariable String id, Model model) {
        model.addAttribute("ciclo", id);
        return "ciclo";
    }

    @GetMapping("/numero/{numero}")
    public String numero(@PathVariable int numero, Model model) {
        model.addAttribute("numero", numero);
        return "numero";
    }

    @GetMapping("/asir")
    public String asir(Model model) {
        return "asir";
    }

    @GetMapping("/daw")
    public String daw(Model model) {
        return "daw";
    }

    @GetMapping("/smr")
    public String smr(Model model) {
        return "smr";
    }
}
