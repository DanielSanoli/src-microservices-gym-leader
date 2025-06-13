package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonType implements Serializable {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Data
    public static class Type implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
