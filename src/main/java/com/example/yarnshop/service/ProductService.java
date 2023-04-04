package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.view.OrderDetailView;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Sale;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final YarnService yarnService;
    private final AccessoryService accessoryService;
    private final ToyService toyService;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(YarnService yarnService, AccessoryService accessoryService, ToyService toyService, UserRepository userRepository, ModelMapper modelMapper) {
        this.yarnService = yarnService;
        this.accessoryService = accessoryService;
        this.toyService = toyService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public List<ProductWithInfoDto> addProductToCart(ProductWithInfoDto product, Integer quantity){
        List<ProductWithInfoDto> productsToCart = new ArrayList<>();

        product.setSum(product.getPrice ().multiply (BigDecimal.valueOf (product.getQuantity())));

        productsToCart.add(product);
        return productsToCart;
    }
}
