package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
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
        var category = accessoryCategoryRepository.findAccessoryCategoryById(accessoryDto.getCategoryId());


        accessory.setCategory(category);
        accessory.setName(accessoryDto.getName());
        accessory.setColor(accessoryDto.getColor());
        accessory.setMaterial(accessoryDto.getMaterial());
        accessory.setCountry(country);
        accessory.setPrice(accessoryDto.getPrice());
        accessory.setSize(accessoryDto.getSize());
        accessory.setDescription(accessoryDto.getDescription());
        accessory.setImageUrl(accessoryDto.getImageUrl());
        accessory.setQuantity(accessoryDto.getQuantity());

        accessoryRepository.save(accessory);
    }

    public List<Accessory> getAllYarns(){
        return accessoryRepository.findAll();
    }
    public ProductWithInfoDto getProductInfoById(Long id) {
        Accessory accessory = this.accessoryRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
        return this.modelMapper.map(accessory, ProductWithInfoDto.class);
    }

    public void editProduct(Long productId, ProductWithInfoDto editProductDTO) {
        Accessory accessoryToEdit = this.accessoryRepository.findById(productId)
                .orElseThrow(() -> new Error("Product not found!"));
        accessoryToEdit.setDescription(editProductDTO.getDescription());
        accessoryToEdit.setPrice(editProductDTO.getPrice());
        accessoryToEdit.setImageUrl(editProductDTO.getImageUrl());
        this.accessoryRepository.save(accessoryToEdit);
    }

    public void deleteProductById(Long productId) {
        this.accessoryRepository.deleteById(productId);
    }
        public List<Accessory> getAllAccessories(){
        return accessoryRepository.findAll();
        }
}
