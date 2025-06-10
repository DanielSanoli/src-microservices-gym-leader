package br.com.gymleader.service;

import br.com.gymleader.model.Generation;
import br.com.gymleader.model.Pokemon;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonAPI {

    private final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final String POKEAPI_GENERATION_URL = "https://pokeapi.co/api/v2/generation/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable("pokemon")
    public Pokemon getPokemonByIdOrName(String idOrName) {
        String url = POKEAPI_URL + idOrName.toLowerCase();
        return restTemplate.getForObject(url, Pokemon.class);
    }

    @Cacheable("generation")
    public List<Pokemon> getPokemonsByGeneration(int generationId, String type, Integer minWeight) {
        String url =  POKEAPI_GENERATION_URL + generationId;
        Generation generation = restTemplate.getForObject(url, Generation.class);

        return generation.getPokemon_species()
                .parallelStream()
                .map(species -> {
                    String pokemonName = species.getName();
                    return getPokemonByIdOrName(pokemonName);
                })
                .filter(pokemon -> type == null || pokemon.getTypes().stream()
                        .anyMatch(t -> t.getType().getName().equalsIgnoreCase(type)))
                .filter(pokemon -> minWeight == null || pokemon.getWeight() >= minWeight)
                .collect(Collectors.toList());
    }

}
