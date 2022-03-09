package com.jjeanjacques.solidgood.service.impl.training;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;

public interface TrainingValidation {

    void valid(PokemonDTO pokemon, TrainingDTO training);

}
