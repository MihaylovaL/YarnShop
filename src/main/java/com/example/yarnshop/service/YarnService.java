package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.model.entity.Yarn;
import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.model.enums.Category;
import com.example.yarnshop.repository.CountryRepository;
import com.example.yarnshop.repository.YarnCategoryRepository;
import com.example.yarnshop.repository.YarnRepository;
import org.springframework.stereotype.Service;

@Service
public class YarnService {
    private final YarnRepository yarnRepository;
    private final YarnCategoryRepository yarnCategoryRepository;
    private final CountryRepository countryRepository;

    public YarnService(YarnRepository yarnRepository, YarnCategoryRepository yarnCategoryRepository, CountryRepository countryRepository) {
        this.yarnRepository = yarnRepository;
        this.yarnCategoryRepository = yarnCategoryRepository;
        this.countryRepository = countryRepository;
    }

    public void addYarn(AddYarnDto yarnDto) {
        Yarn yarn = new Yarn();
        YarnCategory category = yarnCategoryRepository.findByCategory(yarn.getCategory().getCategory());

        yarn.setCategory(category);
        yarn.setName(yarnDto.getName());
        yarn.setColor(yarnDto.getColor());
        yarn.setImage(yarnDto.getImage());
        yarn.setDescription(yarnDto.getDescription());
        yarn.setCountry(countryRepository.findByName(yarnDto.getCountry()).orElseThrow());
        yarn.setLength(yarnDto.getLength());
        yarn.setSize(yarn.getSize());
        yarn.setPrice(yarnDto.getPrice());
        yarn.setWeight(yarnDto.getWeight());

        yarnRepository.save(yarn);
    }

}
