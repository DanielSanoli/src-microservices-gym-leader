package br.com.gymleader.dto;

import java.util.List;
import java.util.Map;

public record PokemonDTO(
        Long id,
        String name,
        List<String> types,
        int height,
        int weight,
        String spriteUrl,
        Map<String, Integer> stats
) {}
