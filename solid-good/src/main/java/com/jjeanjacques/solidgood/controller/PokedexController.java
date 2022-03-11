package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokedexService pokedexService;

    @GetMapping("/pokemon")
    public ResponseEntity getAll(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(pokedexService.getPokemon(name));
        }
        return ResponseEntity.ok(pokedexService.getAllPokemon());
    }

    @DeleteMapping("/pokemon")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pokedexService.deletePokemon(id);
        return ResponseEntity.ok("Pokemon id [" + id + "] deleted");
    }

    @PostMapping("/pokemon")
    public ResponseEntity<String> create(@RequestBody PokemonDTO pokemonDTO) {
        var id = pokedexService.addPokemon(pokemonDTO);
        return ResponseEntity.ok("Pokemon id [" + id + "] created");
    }

}
