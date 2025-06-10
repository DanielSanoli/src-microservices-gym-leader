package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonType implements Serializable {
    private Type type;

    @Data
    public static class Type implements Serializable {
        private String name;
    }
}
