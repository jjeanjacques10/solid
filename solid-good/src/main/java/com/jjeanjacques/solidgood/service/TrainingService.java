package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;

public interface TrainingService {

    PokemonDTO trainPokemon(PokemonDTO pokemon, TrainingDTO training);

}
