package com.jjeanjacques.solidbad.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {

    private Long id;

    @NotNull
    private String name;
    private String description;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int total;
    private int generation;
    private int legendary;
    private String imageUrl;
}
