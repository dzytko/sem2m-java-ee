package com.example.lab5.repositories;

import com.example.lab5.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByContinentIgnoreCase(String continent);

    List<Country> findByPopulationBetween(Integer minPopulation, Integer maxPopulation);

    List<Country> findByContinentIgnoreCaseAndSurfaceAreaBetween(String continent, Integer minArea, Integer maxArea);

}
