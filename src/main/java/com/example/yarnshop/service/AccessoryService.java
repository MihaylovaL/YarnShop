package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.model.entity.Accessory;
import com.example.yarnshop.repository.AccessoryCategoryRepository;
import com.example.yarnshop.repository.AccessoryRepository;
import com.example.yarnshop.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final AccessoryCategoryRepository accessoryCategoryRepository;
    private final CountryRepository countryRepository;

    public AccessoryService(AccessoryRepository accessoryRepository, AccessoryCategoryRepository accessoryCategoryRepository, CountryRepository countryRepository) {
        this.accessoryRepository = accessoryRepository;
        this.accessoryCategoryRepository = accessoryCategoryRepository;
        this.countryRepository = countryRepository;
    }

    public void addAccessory(AddAccessoryDto accessoryDto) {
        Accessory accessory = new Accessory();
        var country = countryRepository.findById(accessoryDto.getCountryId()).orElseThrow();
        var category = accessoryCategoryRepository.findYarnCategoryById(accessoryDto.getCategoryId());


        accessory.setCategory(category);
        accessory.setName(accessoryDto.getName());
        accessory.setColor(accessoryDto.getColor());
        accessory.setMaterial(accessoryDto.getMaterial());
        accessory.setCountry(country);
        accessory.setPrice(accessoryDto.getPrice());
        accessory.setSize(accessoryDto.getSize());
        accessory.setDescription(accessoryDto.getDescription());

        accessoryRepository.save(accessory);
    }
}
