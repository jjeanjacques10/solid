package com.jjeanjacques.solidbad.controller;

import com.jjeanjacques.solidbad.controller.dto.PokemonDTO;
import com.jjeanjacques.solidbad.controller.dto.TrainingDTO;
import com.jjeanjacques.solidbad.service.PokedexService;
import com.jjeanjacques.solidbad.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private PokedexService pokedexService;

    @Autowired
    private TrainingService trainingService;

    @PostMapping("/{id}")
    public ResponseEntity<PokemonDTO> training(@PathVariable Long id,
                                               @RequestBody TrainingDTO trainingDTO) {
        var pokemon = pokedexService.getPokemon(id);
        var pokemonTrained = trainingService.trainPokemon(pokemon, trainingDTO);
        return ResponseEntity.ok(pokemonTrained);
    }

}
