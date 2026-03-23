package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
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
