package com.example.lab5.controllers;

import com.example.lab5.entities.Country;
import com.example.lab5.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


// http://localhost:8080/country/continent/Asia
// http://localhost:8080/country/population/min/10000/max/1000000
// http://localhost:8080/country/continent/Europe/area/min/10000/max/100000
@Controller
@AllArgsConstructor
@RequestMapping("country")
public class CountryController {
    private final CountryRepository countryRepository;

    @GetMapping("/continent/{continent}")
    @ResponseBody
    public String getCountriesByContinent(@PathVariable String continent) {
        List<Country> countries = countryRepository.findByContinentIgnoreCase(continent);
        return formatCountries(countries);
    }

    @GetMapping("/population/min/{minPopulation}/max/{maxPopulation}")
    @ResponseBody
    public String getCountriesByPopulationRange(
            @PathVariable("minPopulation") Integer minPopulation,
            @PathVariable("maxPopulation") Integer maxPopulation) {
        List<Country> countries = countryRepository.findByPopulationBetween(minPopulation, maxPopulation);
        return formatCountries(countries);
    }

    @GetMapping("/continent/{continent}/area/min/{minArea}/max/{maxArea}")
    @ResponseBody
    public String getCountriesByContinentAndAreaRange(
            @PathVariable("continent") String continent,
            @PathVariable("minArea") Integer minArea,
            @PathVariable("maxArea") Integer maxArea) {
        List<Country> countries = countryRepository.findByContinentIgnoreCaseAndSurfaceAreaBetween(continent, minArea, maxArea);
        return formatCountries(countries);
    }

    private String formatCountries(List<Country> countries) {
        return countries.stream()
                .map(Country::toString)
                .collect(Collectors.joining("<br>"));
    }
}
