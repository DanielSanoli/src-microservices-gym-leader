package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Generation implements Serializable {
    private List<PokemonSpecies> pokemon_species;

    public List<PokemonSpecies> getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(List<PokemonSpecies> pokemon_species) {
        this.pokemon_species = pokemon_species;
    }

    @Data
    public static class PokemonSpecies implements Serializable {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}