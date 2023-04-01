package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.AddToyDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Toy;
import com.example.yarnshop.repository.ToyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {
    private final ToyRepository toyRepository;
    private final ModelMapper modelMapper;

    public ToyService(ToyRepository toyRepository, ModelMapper modelMapper) {
        this.toyRepository = toyRepository;
        this.modelMapper = modelMapper;
    }
    public void addToy(AddToyDto addToyDto){
        Toy toy = new Toy();

        toy.setHeight(addToyDto.getHeight());
        toy.setDescription(addToyDto.getDescription());
        toy.setPrice(addToyDto.getPrice());
        toy.setName(addToyDto.getName());
        toy.setImageUrl(addToyDto.getImage());

        toyRepository.save(toy);
    }

    public List<Toy> getAllToys(){
        return toyRepository.findAll();
    }
    public ProductWithInfoDto getProductInfoById(Long id) {
        Toy toy = this.toyRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
        return this.modelMapper.map(toy, ProductWithInfoDto.class);
    }

    public void editProduct(Long productId, ProductWithInfoDto editProductDTO) {
        Toy toyToEdit = this.toyRepository.findById(productId)
                .orElseThrow(() -> new Error("Product not found!"));
        toyToEdit.setDescription(editProductDTO.getDescription());
        toyToEdit.setPrice(editProductDTO.getPrice());
        toyToEdit.setImageUrl(editProductDTO.getImageUrl());
        this.toyRepository.save(toyToEdit);
    }

    public void deleteProductById(Long productId) {
        this.toyRepository.deleteById(productId);
    }

    public Toy findToyById(Long id){
        return toyRepository.findById(id).orElseThrow();
    }


}
