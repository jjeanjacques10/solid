package com.jjeanjacques.solidgood.repository.dto;

import com.jjeanjacques.solidgood.enums.TypePokemon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerTypeContract {

    private TypePokemon type;
    private Long value;

}
