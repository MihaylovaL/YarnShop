package com.example.services;

import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.model.enums.Category;
import com.example.yarnshop.repository.YarnCategoryRepository;
import com.example.yarnshop.service.YarnCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class YarnCategoryServiceTest {
    private YarnCategoryService yarnCategoryService;
    private YarnCategoryRepository yarnCategoryRepository;

    @BeforeEach
    void setUp() {
        yarnCategoryRepository = mock(YarnCategoryRepository.class);
        yarnCategoryService = new YarnCategoryService(yarnCategoryRepository);
    }

    @Test
    void testGetAllYarnCategories() {
        // arrange
        YarnCategory category1 = new YarnCategory().setId(1L).setCategory(Category.COTTON);
        YarnCategory category2 = new YarnCategory().setId(2L).setCategory(Category.WOOL);
        List<YarnCategory> categories = Arrays.asList(category1, category2);

        when(yarnCategoryRepository.findAll()).thenReturn(categories);

        // act
        List<YarnCategory> result = yarnCategoryService.getAllYarnCategories();

        // assert
        assertEquals(categories.size(), result.size());
        assertEquals(categories.get(0).getId(), result.get(0).getId());
        assertEquals(categories.get(0).getCategory(), result.get(0).getCategory());
        assertEquals(categories.get(1).getId(), result.get(1).getId());
        assertEquals(categories.get(1).getCategory(), result.get(1).getCategory());
    }
}
