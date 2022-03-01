package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.entity.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokedexService {

    void calculateTotalSum();
    List<PokemonDTO> getAllPokemon();
    PokemonDTO getPokemon(String name);
    Long addPokemon(PokemonDTO pokemonDTO);
    void deletePokemon(Long id);

}
