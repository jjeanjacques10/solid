package com.jjeanjacques.solidgood.repository;

import com.jjeanjacques.solidgood.entity.Pokemon;
import com.jjeanjacques.solidgood.repository.dto.PowerTypeContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT COUNT(p) FROM Pokemon p WHERE year(p.capturedAt) = :year AND month(p.capturedAt) = :month")
    Integer totalPokemon(int year, int month);

    @Query("SELECT COUNT(p) FROM Pokemon p")
    Integer totalPokemon();

    @Query("SELECT SUM(p.attack) FROM Pokemon p WHERE year(p.capturedAt) = :year AND month(p.capturedAt) = :month")
    Integer totalPowerPokemon(int year, int month);

    @Query("SELECT new com.jjeanjacques.solidgood.repository.dto.PowerTypeContract(p.type, sum(p.attack)) FROM Pokemon p " +
            "WHERE year(p.capturedAt) = :year AND month(p.capturedAt) = :month " +
            "GROUP BY p.type")
    List<PowerTypeContract> getAttackByType(int year, int month);

}
