package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.view.AddProductToCartDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProductWithInfoDto> addProductToCart(ProductWithInfoDto product){
        List<ProductWithInfoDto> productsToCart = new ArrayList<>();
            productsToCart.add(product);
        return productsToCart;
    }
}
