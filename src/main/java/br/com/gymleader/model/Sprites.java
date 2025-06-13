package br.com.gymleader.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sprites implements Serializable {

    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

}
