package br.com.gymleader.converter;

import br.com.gymleader.dto.PokemonDTO;
import br.com.gymleader.model.Pokemon;
import br.com.gymleader.model.PokemonStat;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PokemonConverter {

    public PokemonDTO toDto(Pokemon pokemon) {
        return new PokemonDTO(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getTypes().stream()
                        .map(type -> type.getType().getName().toLowerCase())
                        .toList(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getSprites() != null ? pokemon.getSprites().getFrontDefault() : null,
                extractStats(pokemon.getStats())
        );
    }

    private Map<String, Integer> extractStats(List<PokemonStat> stats) {
        if (stats == null) return Map.of();

        Map<String, Integer> statsMap = new HashMap<>();
        for (PokemonStat stat : stats) {
            if (stat != null && stat.getStat() != null) {
                String statName = stat.getStat().getName();
                statName = statName.equals("special-attack") ? "specialAttack" :
                        statName.equals("special-defense") ? "specialDefense" :
                                statName;
                statsMap.put(statName, stat.getBaseStat());
            }
        }
        return statsMap;
    }
}