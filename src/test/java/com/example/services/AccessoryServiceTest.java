package com.example.services;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Accessory;
import com.example.yarnshop.model.entity.AccessoryCategory;
import com.example.yarnshop.model.entity.Country;
import com.example.yarnshop.model.enums.AccessoryEnum;
import com.example.yarnshop.repository.AccessoryCategoryRepository;
import com.example.yarnshop.repository.AccessoryRepository;
import com.example.yarnshop.repository.CountryRepository;
import com.example.yarnshop.service.AccessoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccessoryServiceTest {
    @Mock
    private AccessoryRepository accessoryRepository;

    @Mock
    private AccessoryCategoryRepository accessoryCategoryRepository;

    @Mock
    private CountryRepository countryRepository;

    private ModelMapper modelMapper;

    private AccessoryService accessoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
        accessoryService = new AccessoryService(accessoryRepository, accessoryCategoryRepository, countryRepository, modelMapper);
    }

    @Test
    void testAddAccessory() {
        // Given
        var country = new Country();
        country.setName("Vietnam");
        var category = new AccessoryCategory();
        category.setCategory(AccessoryEnum.HOOK);


        AddAccessoryDto accessoryDto = new AddAccessoryDto();
        accessoryDto.setName("Accessory 1");
        accessoryDto.setColor("Red");
        accessoryDto.setMaterial("Cotton");
        accessoryDto.setCategoryId(1L);
        accessoryDto.setCountryId(1L);
        accessoryDto.setPrice(BigDecimal.TEN);
        accessoryDto.setSize("Large");
        accessoryDto.setDescription("A description");
        accessoryDto.setImageUrl("https://image.com/accessory1.jpg");
        accessoryDto.setQuantity(100);

        Accessory expectedAccessory = new Accessory();
        expectedAccessory.setCategory(category);
        expectedAccessory.setName("Accessory 1");
        expectedAccessory.setColor("Red");
        expectedAccessory.setMaterial("Cotton");
        expectedAccessory.setCountry(country);
        expectedAccessory.setPrice(BigDecimal.TEN);
        expectedAccessory.setSize("Large");
        expectedAccessory.setDescription("A description");
        expectedAccessory.setImageUrl("https://image.com/accessory1.jpg");
        expectedAccessory.setQuantity(100);

        accessoryService.addAccessory(accessoryDto);
        verify(accessoryRepository, times(1)).save(expectedAccessory);
    }

    @Test
    void testGetAllAccessories() {
        // Given
        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new Accessory());
        accessories.add(new Accessory());
        accessories.add(new Accessory());

        when(accessoryRepository.findAll()).thenReturn(accessories);

        // When
        List<Accessory> actualAccessories = accessoryService.getAllAccessories();

        // Then
        assertEquals(accessories.size(), actualAccessories.size());
    }

    @Test
    void testGetProductInfoById() {
        // Given
        Accessory accessory = new Accessory();
        accessory.setId(1L);
        accessory.setName("testAccessory");
        accessory.setColor("red");
        accessory.setMaterial("cotton");
        accessory.setPrice(BigDecimal.valueOf(10));
        accessory.setSize("large");
        accessory.setDescription("test description");
        accessory.setImageUrl("http://test.com");
        accessory.setQuantity(10);

        when(accessoryRepository.findById(1L)).thenReturn(Optional.of(accessory));

        // When
        ProductWithInfoDto productInfo = accessoryService.getProductInfoById(1L);

    }
}
