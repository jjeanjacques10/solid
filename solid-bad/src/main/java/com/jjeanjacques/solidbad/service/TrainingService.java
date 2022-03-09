package com.jjeanjacques.solidbad.service;

import com.jjeanjacques.solidbad.controller.dto.PokemonDTO;
import com.jjeanjacques.solidbad.controller.dto.TrainingDTO;
import com.jjeanjacques.solidbad.entity.Pokemon;
import com.jjeanjacques.solidbad.exception.InvalidTraining;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TrainingService {

    @Autowired
    PokedexService pokedexService;

    @Autowired
    ModelMapper modelMapper;

    public PokemonDTO trainPokemon(PokemonDTO pokemon, TrainingDTO training) {
        if (pokemon.getLastWorkout() != null) {
            var hoursBetweenDates = ChronoUnit.HOURS.between(pokemon.getLastWorkout(), LocalDateTime.now());
            if (hoursBetweenDates < 8) {
                throw new InvalidTraining("Your pokemon is tired, wait 8 hours");
            }
        }

        if (pokemon.getAttack() > 1000) {
            throw new InvalidTraining("Pokemon attack cannot be greater than 1000");
        }

        int newAttack = Math.round(pokemon.getAttack() + (pokemon.getAttack() * (training.getIntension() / 100)));
        int newDefense = Math.round(pokemon.getDefense() + (pokemon.getDefense() * (training.getIntension() / 100)));
        pokemon.setAttack(newAttack);
        pokemon.setDefense(newDefense);
        pokemon.setLastWorkout(LocalDateTime.now());
        pokedexService.update(modelMapper.map(pokemon, Pokemon.class));
        return pokemon;
    }

}
