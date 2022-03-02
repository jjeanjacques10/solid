package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.controller.dto.PokemonDTO;
import com.jjeanjacques.solidgood.controller.dto.ReportCatchDTO;
import com.jjeanjacques.solidgood.controller.dto.ReportDTO;
import com.jjeanjacques.solidgood.repository.PokemonRepository;
import com.jjeanjacques.solidgood.repository.ReportRepository;
import com.jjeanjacques.solidgood.service.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReportDTO printReport(int month, int year) {
        var totalPokemon = reportRepository.totalPokemon(month, year);
        var power = reportRepository.totalPowerPokemon(month, year);
        var categories = reportRepository.getAttackByType(month, year);

        return ReportDTO.builder()
                .total(totalPokemon)
                .power(power)
                .categories(categories)
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public ReportCatchDTO showCatch() {
        var totalPokemon = reportRepository.totalPokemon();
        var pokemons = pokemonRepository.findAll();

        return ReportCatchDTO.builder()
                .total(totalPokemon)
                .pokemon(pokemons.stream().map(p -> modelMapper.map(p, PokemonDTO.class))
                        .collect(Collectors.toList()))
                .createdAt(LocalDateTime.now())
                .build();
    }
}
