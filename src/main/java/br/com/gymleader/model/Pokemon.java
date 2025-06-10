package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pokemon implements Serializable {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;
    private List<PokemonStat> stats;

}
