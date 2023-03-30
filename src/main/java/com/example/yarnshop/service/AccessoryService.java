package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.model.dtos.view.AccessoryWithInfoView;
import com.example.yarnshop.model.dtos.view.YarnWithInfoView;
import com.example.yarnshop.model.entity.Accessory;
import com.example.yarnshop.repository.AccessoryCategoryRepository;
import com.example.yarnshop.repository.AccessoryRepository;
import com.example.yarnshop.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final AccessoryCategoryRepository accessoryCategoryRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public AccessoryService(AccessoryRepository accessoryRepository, AccessoryCategoryRepository accessoryCategoryRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.accessoryRepository = accessoryRepository;
        this.accessoryCategoryRepository = accessoryCategoryRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
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
        accessory.setImageUrl(accessoryDto.getImageUrl());

        accessoryRepository.save(accessory);
    }

    public List<Accessory> getAllYarns(){
        return accessoryRepository.findAll();
    }
    public AccessoryWithInfoView getProductInfoById(Long id) {
        Accessory accessory = this.accessoryRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
        return this.modelMapper.map(accessory, AccessoryWithInfoView.class);
    }

}
