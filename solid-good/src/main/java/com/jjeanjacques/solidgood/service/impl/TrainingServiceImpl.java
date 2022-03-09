package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;
import com.jjeanjacques.solidgood.entity.Pokemon;
import com.jjeanjacques.solidgood.repository.PokemonRepository;
import com.jjeanjacques.solidgood.service.TrainingService;
import com.jjeanjacques.solidgood.service.impl.training.TrainingValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final PokemonRepository pokemonRepository;

    private final ModelMapper modelMapper;

    public List<TrainingValidation> validations;

    @Autowired
    public TrainingServiceImpl(List<TrainingValidation> validations, ModelMapper modelMapper, PokemonRepository pokemonRepository) {
        this.validations = validations;
        this.modelMapper = modelMapper;
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonDTO trainPokemon(PokemonDTO pokemon, TrainingDTO training) {
        validations.forEach(v -> v.valid(pokemon, training));
        setNewAttributes(pokemon, training);
        return pokemon;
    }

    private void setNewAttributes(PokemonDTO pokemon, TrainingDTO training) {
        int newAttack = Math.round(pokemon.getAttack() + (pokemon.getAttack() * (training.getIntension() / 100)));
        int newDefense = Math.round(pokemon.getDefense() + (pokemon.getDefense() * (training.getIntension() / 100)));
        pokemon.setAttack(newAttack);
        pokemon.setDefense(newDefense);
        pokemon.setLastWorkout(LocalDateTime.now());
        pokemonRepository.save(modelMapper.map(pokemon, Pokemon.class));
    }

}
