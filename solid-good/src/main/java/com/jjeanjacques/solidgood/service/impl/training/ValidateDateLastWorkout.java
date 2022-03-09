package com.jjeanjacques.solidgood.service.impl.training;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;
import com.jjeanjacques.solidgood.exception.InvalidTraining;

import java.time.temporal.ChronoUnit;

public class ValidateDateLastWorkout implements TrainingValidation {

    @Override
    public void valid(PokemonDTO pokemon, TrainingDTO training) {
        if (pokemon.getLastWorkout() != null) {
            var hoursBetweenDates = ChronoUnit.HOURS.between(pokemon.getLastWorkout(), training.getDate());
            if (hoursBetweenDates < 8)
                throw new InvalidTraining("Your pokemon is tired, wait 8 hours");
        }
    }

}
