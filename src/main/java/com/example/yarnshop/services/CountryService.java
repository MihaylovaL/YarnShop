package com.example.yarnshop.services;

import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findByName(Long countryId){
        return countryRepository.findById(countryId).orElseThrow();
    }
    public List<Country> findAll(){
        List<Country> all = countryRepository.findAll();
        return all;

    }
}
