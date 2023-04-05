package com.example.services;

import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.*;
import com.example.yarnshop.repository.UserRepository;
import com.example.yarnshop.service.AccessoryService;
import com.example.yarnshop.service.ProductService;
import com.example.yarnshop.service.ToyService;
import com.example.yarnshop.service.YarnService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ProductServiceTest {
    private ProductService productService;
    private YarnService yarnService;
    private AccessoryService accessoryService;
    private ToyService toyService;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        yarnService = mock(YarnService.class);
        accessoryService = mock(AccessoryService.class);
        toyService = mock(ToyService.class);
        userRepository = mock(UserRepository.class);
        modelMapper = new ModelMapper();

        productService = new ProductService(yarnService, accessoryService, toyService, userRepository, modelMapper);

        // Initialize test data
       ProductWithInfoDto product = new ProductWithInfoDto();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test description");
        product.setPrice(BigDecimal.TEN);
        product.setQuantity(2);

        YarnShopUser user = new YarnShopUser();
        user.setUsername("testuser");

        Principal principal = new UsernamePasswordAuthenticationToken(user, null);
    }

    @Test
    public void testAddProductToCart() {
        // Arrange
        ProductWithInfoDto product = new ProductWithInfoDto();
        product.setId(1L);
        product.setName("Test product");
        product.setPrice(BigDecimal.valueOf(10));
        product.setQuantity(2);

        // Act
        List<ProductWithInfoDto> productsToCart = productService.addProductToCart(product, product.getQuantity());

        // Assert
        assertEquals(productsToCart.size(), 1);
        assertEquals(productsToCart.get(0).getSum(), BigDecimal.valueOf(20));
    }
}