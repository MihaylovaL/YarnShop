package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Yarn;
import com.example.yarnshop.repository.CountryRepository;
import com.example.yarnshop.repository.YarnCategoryRepository;
import com.example.yarnshop.repository.YarnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YarnService {
    private final YarnRepository yarnRepository;
    private final YarnCategoryRepository yarnCategoryRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public YarnService(YarnRepository yarnRepository, YarnCategoryRepository yarnCategoryRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.yarnRepository = yarnRepository;
        this.yarnCategoryRepository = yarnCategoryRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public void addYarn(AddYarnDto yarnDto) {
        Yarn yarn = new Yarn();
        var country = countryRepository.findById(yarnDto.getCountryId()).orElseThrow();
        var category = yarnCategoryRepository.findYarnCategoryById(yarnDto.getCategoryId());


        yarn.setCategory(category);
        yarn.setName(yarnDto.getName());
        yarn.setColor(yarnDto.getColor());
        yarn.setDescription(yarnDto.getDescription());
        yarn.setCountry(country);
        yarn.setLength(yarnDto.getLength());
        yarn.setPrice(yarnDto.getPrice());
        yarn.setWeight(yarnDto.getWeight());
        yarn.setImageUrl(yarnDto.getImage());

        yarnRepository.save(yarn);
    }

    public List<Yarn> getAllYarns(){
        return yarnRepository.findAll();
    }
    public ProductWithInfoDto getProductInfoById(Long id) {
        Yarn yarn = this.yarnRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
        return this.modelMapper.map(yarn, ProductWithInfoDto.class);
    }

    public void editProduct(Long productId, ProductWithInfoDto editProductDTO) {
        Yarn yarnToEdit = this.yarnRepository.findById(productId)
                .orElseThrow(() -> new Error("Product not found!"));
        yarnToEdit.setDescription(editProductDTO.getDescription());
        yarnToEdit.setPrice(editProductDTO.getPrice());
        yarnToEdit.setImageUrl(editProductDTO.getImageUrl());
        this.yarnRepository.save(yarnToEdit);
    }

    public void deleteProductById(Long productId) {
        this.yarnRepository.deleteById(productId);
    }

}
