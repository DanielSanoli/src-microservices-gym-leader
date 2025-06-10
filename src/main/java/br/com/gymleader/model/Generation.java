package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Generation implements Serializable {
    private List<PokemonSpecies> pokemon_species;

    @Data
    public static class PokemonSpecies implements Serializable {
        private String name;
        private String url;
    }
}