package com.cognizant.controller;

import com.cognizant.model.Country;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    // list of countries
    private List<Country> countryList = Arrays.asList(
        new Country("IN", "India"),
        new Country("US", "United States"),
        new Country("JP", "Japan"),
        new Country("DE", "Germany")
    );

    @RequestMapping("/country")
    public Country getCountryIndia() {
        return new Country("IN", "India");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryList;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryList.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
    }
}
