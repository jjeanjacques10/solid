package com.jjeanjacques.solidgood.service.impl.training;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;
import com.jjeanjacques.solidgood.exception.InvalidTraining;

public class ValidatePokemonPowerLimit implements TrainingValidation {

    @Override
    public void valid(PokemonDTO pokemon, TrainingDTO training) {
        if (pokemon.getAttack() > 1000)
            throw new InvalidTraining("Pokemon attack cannot be greater than 1000");
    }

}
