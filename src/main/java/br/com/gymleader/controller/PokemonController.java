package br.com.gymleader.controller;

import br.com.gymleader.converter.PokemonConverter;
import br.com.gymleader.dto.PokemonDTO;
import br.com.gymleader.model.PaginatedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.gymleader.model.Pokemon;
import br.com.gymleader.service.PokemonAPI;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonAPI pokemonService;
    private final PokemonConverter pokemonConverter;

    @Autowired
    public PokemonController(PokemonAPI pokemonService, PokemonConverter pokemonConverter) {
        this.pokemonService = pokemonService;
        this.pokemonConverter = pokemonConverter;
    }

    @GetMapping("/{idOrName}")
    public PokemonDTO getPokemon(@PathVariable String idOrName) {
        Pokemon pokemon = pokemonService.getPokemonByIdOrName(idOrName);
        return pokemonConverter.toDto(pokemon);
    }

    @GetMapping("/generation/{generationId}")
    public PaginatedResponse<Pokemon> getByGeneration(
            @PathVariable int generationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer min_weight) {

        List<Pokemon> filteredPokemons = pokemonService.getPokemonsByGeneration(
                generationId,
                type,
                min_weight
        );

        int totalPokemons = filteredPokemons.size();
        int start = page * size;
        int end = Math.min(start + size, totalPokemons);

        List<Pokemon> paginatedPokemons = filteredPokemons.subList(start, end);

        return new PaginatedResponse<>(
                paginatedPokemons,
                page,
                size,
                totalPokemons
        );
    }
}

