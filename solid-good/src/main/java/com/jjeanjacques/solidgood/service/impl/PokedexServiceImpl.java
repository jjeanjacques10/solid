package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.entity.Pokemon;
import com.jjeanjacques.solidgood.exception.NotFoundPokemon;
import com.jjeanjacques.solidgood.repository.PokemonRepository;
import com.jjeanjacques.solidgood.service.PokedexService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokedexServiceImpl implements PokedexService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void calculateTotalSum() {

    }

    @Override
    public List<PokemonDTO> getAllPokemon() {
        var pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(p -> modelMapper.map(p, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDTO getPokemon(String name) {
        var pokemon = pokemonRepository.findByNameContaining(name);
        if (pokemon == null)
            throw new NotFoundPokemon("Pokemon with name " + name + " not found");
        return modelMapper.map(pokemon, PokemonDTO.class);
    }

    @Override
    public PokemonDTO getPokemon(Long id) {
        var pokemon = pokemonRepository.findById(id).get();
        if (pokemon == null)
            throw new NotFoundPokemon("Pokemon with id " + id + " not found");
        return modelMapper.map(pokemon, PokemonDTO.class);
    }

    @Override
    @Transactional
    public Long addPokemon(PokemonDTO pokemonDTO) {
        var pokemon = modelMapper.map(pokemonDTO, Pokemon.class);
        var pokemonSaved = pokemonRepository.save(pokemon);
        return pokemonSaved.getId();
    }

    @Override
    @Transactional
    public void deletePokemon(Long id) {
        if (pokemonRepository.existsById(id))
            throw new NotFoundPokemon("Pokemon with id " + id + " not found");
        pokemonRepository.deleteById(id);
    }
}
