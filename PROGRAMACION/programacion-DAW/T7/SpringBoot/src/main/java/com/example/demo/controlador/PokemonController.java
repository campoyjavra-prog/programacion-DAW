package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.modelo.Pokemon;
import com.example.demo.service.PokemonService;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping({ "/pokemon", "/pokemon/{id}" })
    public String mostrarPokemon(@PathVariable(required = false) Integer id, Model model) {
        // Por defecto empezamos en el Pokémon 1
        if (id == null) {
            id = 1;
        }
        
        // Calculamos anterior y siguiente (mínimo 1, máximo 1025 por ejemplo)
        int idAnterior = (id > 1) ? id - 1 : 1;
        int idSiguiente = id + 1;
        
        Pokemon pokemon = service.obtenerPokemon(id);
        
        if (pokemon == null) {
            model.addAttribute("error", "No se pudo obtener el Pokémon con id: " + id);
            return "error"; // plantilla error.html
        }
        
        // Sobrescribimos la imagen por el artwork oficial si lo deseamos así
        pokemon.setImagen(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id
                        + ".png");
        
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("id", id);
        model.addAttribute("idAnterior", idAnterior);
        model.addAttribute("idSiguiente", idSiguiente);
        
        return "pokemon"; // plantilla pokemon.html
    }
}
