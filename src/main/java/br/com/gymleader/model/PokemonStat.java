package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonStat implements Serializable {
    private int baseStat;
    private Stat stat;

    public int getBase_stat() {
        return baseStat;
    }

    public void setBase_stat(int base_stat) {
        this.baseStat = base_stat;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @Data
    public static class Stat implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
