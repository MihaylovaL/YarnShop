package com.example.yarnshop.services;

import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.repositories.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findByName(String name){
        return countryRepository.findByName(name).orElseThrow();
    }
}
