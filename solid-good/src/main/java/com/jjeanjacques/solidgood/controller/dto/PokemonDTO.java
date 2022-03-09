package com.jjeanjacques.solidgood.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jjeanjacques.solidgood.enums.TypePokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private TypePokemon type;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("captured_at")
    private LocalDateTime capturedAt;
    @JsonProperty("last_workout")
    private LocalDateTime lastWorkout;

}
