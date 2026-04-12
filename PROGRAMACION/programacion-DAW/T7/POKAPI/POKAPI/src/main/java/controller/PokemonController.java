package controller;

import model.Pokemon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.PokemonService;

import java.util.List;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public String raiz() {
        return "redirect:/generaciones/1";
    }

    @GetMapping("/generaciones/{gen}")
    public String generaciones(@PathVariable int gen, Model model) {
        if (gen == 1 || gen == 2) {
            List<Pokemon> pokemons = pokemonService.obtenerAleatoriosGeneracion(gen);
            for (Pokemon pokemon : pokemons) {
                pokemon.setImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemon.getNumero() + ".png");
            }
            model.addAttribute("pokemons", pokemons);
            return "index";
        } else if (gen == 3) {
            return "error";
        }
        return "error";
    }

    @GetMapping("/pokemon/{id}")
    public String detallePokemon(@PathVariable int id, Model model) {
        Pokemon pokemon = pokemonService.obtenerPokemon(id);
        if (pokemon == null) {
            model.addAttribute("error", "pokemon no encontrado");
            return "error";
        }
        
        pokemon.setImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemon.getNumero() + ".png");
        model.addAttribute("pokemon", pokemon);
        return "pokemonDetalle";
    }
}
