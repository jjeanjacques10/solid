package com.jjeanjacques.solidbad.service;

import com.jjeanjacques.solidbad.controller.dto.PokemonDTO;
import com.jjeanjacques.solidbad.controller.dto.ReportCatchDTO;
import com.jjeanjacques.solidbad.controller.dto.ReportDTO;
import com.jjeanjacques.solidbad.entity.Pokemon;
import com.jjeanjacques.solidbad.exception.NotFoundPokemon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* God Class */
@Service
public class PokedexService {

    @Value("${spring.datasource.url}")
    String DATABASE_URL;

    @Value("${spring.datasource.username}")
    String USER;

    @Value("${spring.datasource.password}")
    String PASSWORD;

    @Autowired
    private ModelMapper modelMapper;

    public void calculateTotalSum() {/*<code>*/}

    public List<PokemonDTO> getAllPokemon() {
        var pokemons = findAll();
        return pokemons.stream().map(p -> modelMapper.map(p, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    public PokemonDTO getPokemon(String name) {
        var pokemon = findByNameContaining(name);
        if (pokemon == null)
            throw new NotFoundPokemon("Pokemon with name " + name + " not found");
        return modelMapper.map(pokemon, PokemonDTO.class);
    }

    public PokemonDTO getPokemon(Long id) {
        var pokemon = findById(id);
        if (pokemon == null)
            throw new NotFoundPokemon("Pokemon with id " + id + " not found");
        return modelMapper.map(pokemon, PokemonDTO.class);
    }

    public Long addPokemon(PokemonDTO pokemonDTO) {
        var pokemon = modelMapper.map(pokemonDTO, Pokemon.class);
        var pokemonSaved = save(pokemon);
        return pokemonSaved.getId();
    }

    public void deletePokemon(Long id) {
        deleteById(id);
    }

    public ReportDTO printReport() {
        var pokemons = getAllPokemon();
        return ReportDTO.builder()
                .total(pokemons.size())
                .power(pokemons.stream().mapToInt(PokemonDTO::getAttack).sum())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public ReportCatchDTO showCatch() {
        var pokemons = getAllPokemon();
        return ReportCatchDTO.builder()
                .total(pokemons.size())
                .pokemon(pokemons)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public List<Pokemon> findAll() {
        List<Pokemon> pokemons = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            var sql = "SELECT * FROM POKEMON";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                var pokemon = Pokemon.builder()
                        .id(Long.valueOf(result.getInt("id")))
                        .name(result.getString("name"))
                        .description(result.getString("description"))
                        .attack(result.getInt("attack"))
                        .defense(result.getInt("defense"))
                        .speed(result.getInt("speed"))
                        .total(result.getInt("total"))
                        .generation(result.getInt("generation"))
                        .legendary(result.getInt("legendary"))
                        .imageUrl(result.getString("image_url"))
                        .build();
                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemons;
    }

    public Pokemon findByNameContaining(String name) {
        Pokemon pokemon = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            var sql = "SELECT * FROM POKEMON WHERE name LIKE '%" + name + "%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                pokemon = Pokemon.builder()
                        .id(Long.valueOf(result.getInt("id")))
                        .name(result.getString("name"))
                        .description(result.getString("description"))
                        .attack(result.getInt("attack"))
                        .defense(result.getInt("defense"))
                        .speed(result.getInt("speed"))
                        .total(result.getInt("total"))
                        .generation(result.getInt("generation"))
                        .legendary(result.getInt("legendary"))
                        .imageUrl(result.getString("image_url"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public Pokemon findById(Long id) {
        Pokemon pokemon = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            var sql = "SELECT * FROM POKEMON WHERE id = " + id;

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                LocalDateTime lastWorkout = null;
                if (result.getDate("last_workout") != null) {
                    lastWorkout = Instant.ofEpochMilli(result.getDate("last_workout").getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();
                }
                pokemon = Pokemon.builder()
                        .id(Long.valueOf(result.getInt("id")))
                        .name(result.getString("name"))
                        .description(result.getString("description"))
                        .attack(result.getInt("attack"))
                        .defense(result.getInt("defense"))
                        .speed(result.getInt("speed"))
                        .total(result.getInt("total"))
                        .generation(result.getInt("generation"))
                        .legendary(result.getInt("legendary"))
                        .imageUrl(result.getString("image_url"))
                        .lastWorkout(lastWorkout)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public Pokemon save(Pokemon pokemon) {/*<code>*/
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            Class.forName("org.h2.Driver");

            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO POKEMON (name, description, hp, attack, defense, speed, total, generation, legendary, image_url) " +
                    "VALUES ('" + pokemon.getName() + "', '" + pokemon.getDescription() + "', " + pokemon.getHp() + ", " + pokemon.getAttack() + ", " + pokemon.getDefense() + ", " + pokemon.getSpeed() + ", " + pokemon.getTotal() + ", " + pokemon.getGeneration() + ", " + pokemon.getLegendary() + ", '" + pokemon.getImageUrl() + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findByNameContaining(pokemon.getName());
    }

    public Pokemon update(Pokemon pokemon) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            Class.forName("org.h2.Driver");

            Statement statement = connection.createStatement();
            statement.execute("UPDATE POKEMON SET name = '" + pokemon.getName() + "', " +
                    "description = '" + pokemon.getDescription() + "', " +
                    "hp = " + pokemon.getHp() + ", " +
                    "attack = " + pokemon.getAttack() + ", " +
                    "defense = " + pokemon.getDefense() + ", " +
                    "speed = " + pokemon.getSpeed() + ", " +
                    "total = " + pokemon.getTotal() + ", " +
                    "generation = " + pokemon.getGeneration() + ", " +
                    "legendary = " + pokemon.getLegendary() + ", " +
                    "image_url = '" + pokemon.getImageUrl() + "', " +
                    "last_workout = '" + pokemon.getLastWorkout() + "'" +
                    " WHERE id = " + pokemon.getId() + ";");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findById(pokemon.getId());
    }

    public void deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            Class.forName("org.h2.Driver");

            Statement statement = connection.createStatement();
            statement.execute("DELETE * FROM POKEMON WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
