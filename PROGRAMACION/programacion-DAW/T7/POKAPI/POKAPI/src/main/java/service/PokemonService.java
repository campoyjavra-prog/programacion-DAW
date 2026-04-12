package service;

import dto.PokemonResponse;
import model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PokemonService {

    private static final String URL = "https://pokeapi.co/api/v2/pokemon/";

    private RestTemplate restTemplate = new RestTemplate();

    // ---------------------------------------------------------------
    // Obtiene un Pokémon por su ID
    // ---------------------------------------------------------------
    public Pokemon obtenerPokemon(int id) {
        try {
            PokemonResponse response = restTemplate.getForObject(URL + id, PokemonResponse.class);

            if (response == null) {
                throw new RuntimeException("La API devolvió null para el ID: " + id);
            }

            return new Pokemon(response);

        } catch (Exception e) {
            System.err.println("Error al obtener el Pokemon: " + e.getMessage());
            return null;
        }
    }

    // ---------------------------------------------------------------
    // Obtiene 10 Pokémon aleatorios de la generación indicada
    // Gen 1 → IDs del 1 al 151
    // Gen 2 → IDs del 152 al 251
    // ---------------------------------------------------------------
    public List<Pokemon> obtenerAleatoriosGeneracion(int generacion) {
        int min, max;

        if (generacion == 1) {
            min = 1;
            max = 151;
        } else {
            min = 152;
            max = 251;
        }

        // Generamos 10 IDs únicos aleatorios dentro del rango
        List<Integer> ids = new ArrayList<>();
        Random random = new Random();

        while (ids.size() < 10) {
            int id = min + random.nextInt(max - min + 1);
            if (!ids.contains(id)) {
                ids.add(id);
            }
        }

        // Llamamos a obtenerPokemon para cada ID y acumulamos los resultados
        List<Pokemon> lista = new ArrayList<>();
        for (int id : ids) {
            Pokemon pokemon = obtenerPokemon(id);
            if (pokemon != null) {
                lista.add(pokemon);
            }
        }

        return lista;
    }
}
