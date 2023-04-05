package com.example.services;


import com.example.yarnshop.model.dtos.AddToyDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.Toy;
import com.example.yarnshop.repository.ToyRepository;
import com.example.yarnshop.service.ToyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ToyServiceTest {
    @Mock
    private ToyRepository toyRepositoryMock;

    @Mock
    private ModelMapper modelMapperMock;

    @InjectMocks
    private ToyService toyService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddToy() {
        // Arrange
        AddToyDto addToyDto = new AddToyDto();
        addToyDto.setHeight(10);
        addToyDto.setDescription("Test toy");
        addToyDto.setPrice(BigDecimal.TEN);
        addToyDto.setName("Test toy");
        addToyDto.setImage("test.jpg");
        addToyDto.setQuantity(1);

        Toy toy = new Toy();
        toy.setId(1L);
        toy.setHeight(addToyDto.getHeight());
        toy.setDescription(addToyDto.getDescription());
        toy.setPrice(addToyDto.getPrice());
        toy.setName(addToyDto.getName());
        toy.setImageUrl(addToyDto.getImage());
        toy.setQuantity(addToyDto.getQuantity());

        when(toyRepositoryMock.save(any(Toy.class))).thenReturn(toy);

        // Act
        toyService.addToy(addToyDto);

        // Assert
        verify(toyRepositoryMock).save(any(Toy.class));
    }

    @Test
    public void testGetAllToys() {
        // Arrange
        List<Toy> expectedToys = new ArrayList<>();
        expectedToys.add(new Toy());
        expectedToys.add(new Toy());

        when(toyRepositoryMock.findAll()).thenReturn(expectedToys);

        // Act
        List<Toy> actualToys = toyService.getAllToys();

        // Assert
        verify(toyRepositoryMock).findAll();
        assertEquals(expectedToys.size(), actualToys.size());
    }

    @Test
    public void testGetProductInfoById() {
        // Arrange
        Long toyId = 1L;
        Toy toy = new Toy();
        toy.setId(toyId);
        toy.setName("Test toy");

        ProductWithInfoDto expectedDto = new ProductWithInfoDto();
        expectedDto.setId(toyId);
        expectedDto.setName("Test toy");

        when(toyRepositoryMock.findById(toyId)).thenReturn(java.util.Optional.of(toy));
        when(modelMapperMock.map(toy, ProductWithInfoDto.class)).thenReturn(expectedDto);

        // Act
        ProductWithInfoDto actualDto = toyService.getProductInfoById(toyId);

        // Assert
        verify(toyRepositoryMock).findById(toyId);
        verify(modelMapperMock).map(toy, ProductWithInfoDto.class);
        assertEquals(expectedDto.getId(), actualDto.getId());
        assertEquals(expectedDto.getName(), actualDto.getName());
    }

    @Test
    public void testEditProduct() {
        // Create a toy
        Toy toy = new Toy();
        toy.setId(1L);
        toy.setDescription("Old description");
        toy.setPrice(BigDecimal.valueOf(10));
        toy.setImageUrl("https://old.url");
        when(toyRepositoryMock.findById(1L)).thenReturn(Optional.of(toy));
        when(toyRepositoryMock.save(any(Toy.class))).then(AdditionalAnswers.returnsFirstArg());

        // Edit the toy
        ProductWithInfoDto editProductDTO = new ProductWithInfoDto();
        editProductDTO.setDescription("New description");
        editProductDTO.setPrice(BigDecimal.valueOf(20));
        editProductDTO.setImageUrl("https://new.url");
        toyService.editProduct(1L, editProductDTO);

        // Verify that the toy has been updated
        verify(toyRepositoryMock).findById(1L);
        verify(toyRepositoryMock).save(toy);
        assertEquals(editProductDTO.getDescription(), toy.getDescription());
        assertEquals(editProductDTO.getPrice(), toy.getPrice());
        assertEquals(editProductDTO.getImageUrl(), toy.getImageUrl());
    }

    @Test
    public void testDeleteProductById() {
        toyService.deleteProductById(1L);
        verify(toyRepositoryMock).deleteById(1L);
    }

    @Test
    public void testFindToyById() {
        // Create a toy
        Toy toy = new Toy();
        toy.setId(1L);
        toy.setDescription("Description");
        toy.setPrice(BigDecimal.valueOf(10));
        toy.setImageUrl("https://url");
        when(toyRepositoryMock.findById(1L)).thenReturn(Optional.of(toy));

        // Find the toy by ID
        Toy foundToy = toyService.findToyById(1L);

        // Verify that the correct toy has been found
        verify(toyRepositoryMock).findById(1L);
        assertEquals(toy, foundToy);
    }

}
