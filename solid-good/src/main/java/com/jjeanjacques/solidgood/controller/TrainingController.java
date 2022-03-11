package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.TrainingDTO;
import com.jjeanjacques.solidgood.repository.PokemonRepository;
import com.jjeanjacques.solidgood.service.PokedexService;
import com.jjeanjacques.solidgood.service.TrainingService;
import com.jjeanjacques.solidgood.service.impl.TrainingServiceImpl;
import com.jjeanjacques.solidgood.service.impl.training.TrainingValidation;
import com.jjeanjacques.solidgood.service.impl.training.ValidateDateLastWorkout;
import com.jjeanjacques.solidgood.service.impl.training.ValidatePokemonPowerLimit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private PokedexService pokedexService;

    @Autowired
    private PokemonRepository pokemonRepository;

    private TrainingService trainingService;

    @PostMapping("/{id}")
    public ResponseEntity<PokemonDTO> training(@PathVariable Long id,
                                               @RequestBody TrainingDTO trainingDTO) {
        setValidacoes();
        var pokemon = pokedexService.getPokemon(id);
        var pokemonTrained = trainingService.trainPokemon(pokemon, trainingDTO);
        return ResponseEntity.ok(pokemonTrained);
    }

    private void setValidacoes() {
        List<TrainingValidation> validations = List.of(new ValidateDateLastWorkout(), new ValidatePokemonPowerLimit());
        this.trainingService = new TrainingServiceImpl(validations, new ModelMapper(), pokemonRepository);
    }

}
