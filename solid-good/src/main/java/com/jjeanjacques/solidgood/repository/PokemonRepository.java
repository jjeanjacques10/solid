package com.jjeanjacques.solidgood.repository;

import com.jjeanjacques.solidgood.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAll();

    Pokemon findByNameContaining(String name);

    /*
    Pokemon update();

    void delete(Long id);*/

}
