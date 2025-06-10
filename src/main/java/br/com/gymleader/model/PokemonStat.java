package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonStat implements Serializable {
    private int base_stat;
    private Stat stat;

    @Data
    public static class Stat implements Serializable {
        private String name;
    }
}
