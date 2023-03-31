package com.example.yarnshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final YarnService yarnService;
    private final AccessoryService accessoryService;
    private final ToyService toyService;

    @Autowired
    public ProductService(YarnService yarnService, AccessoryService accessoryService, ToyService toyService) {
        this.yarnService = yarnService;
        this.accessoryService = accessoryService;
        this.toyService = toyService;
    }
    /*public List<Product> addProductToCart(AddProductToCartDto addProductToCartDto){

    }*/
}
