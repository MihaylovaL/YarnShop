package com.example.services;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.model.entity.*;
import com.example.yarnshop.model.enums.AccessoryEnum;
import com.example.yarnshop.model.enums.Category;
import com.example.yarnshop.repository.CountryRepository;
import com.example.yarnshop.repository.YarnCategoryRepository;
import com.example.yarnshop.repository.YarnRepository;
import com.example.yarnshop.service.CountryService;
import com.example.yarnshop.service.YarnCategoryService;
import com.example.yarnshop.service.YarnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YarnServiceTest {
    @Autowired
    private YarnRepository yarnRepository;

    @Autowired
    private YarnCategoryRepository yarnCategoryRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @InjectMocks
    private YarnService yarnService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        this.yarnService = new YarnService(yarnRepository, yarnCategoryRepository, countryRepository, modelMapper);

        Country country1 = new Country().setName("Bulgaria").setId(1L);
        Country country2 = new Country().setName("Romania").setId(2L);
        Country country3 = new Country().setName("Turkey").setId(3L);
        Country country4 = new Country().setName("Serbia").setId(4L);
        Country country5 = new Country().setName("Macedonia").setId(5L);
        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        countryRepository.save(country4);
        countryRepository.save(country5);

        var a = countryRepository.findAll();
        System.out.println();
    }

    @Test
    public void testAddYarn() {


        AddYarnDto yarnDto = new AddYarnDto();
        yarnDto.setCountryId(1L);
        yarnDto.setCategoryId(1L);
        yarnDto.setColor("red");
        yarnDto.setDescription("balabla");
        yarnDto.setLength(100);
        yarnDto.setName("test yarn");
        yarnDto.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh-POOQ0XnF2O9Jc_W2xdM_X_SR7lz4tfACg&usqp=CAU");
        yarnDto.setQuantity(50);
        yarnDto.setWeight(120);
        yarnDto.setPrice(BigDecimal.valueOf(10));

        // Invoke the method being tested
        yarnService.addYarn(yarnDto);

        Yarn expected = new Yarn();
        expected.setDescription(yarnDto.getDescription());
        expected.setColor(yarnDto.getColor());
        expected.setQuantity(yarnDto.getQuantity());
        expected.setImageUrl(yarnDto.getImage());
        expected.setWeight(yarnDto.getWeight());
        expected.setLength(yarnDto.getLength());
        expected.setCategory(yarnCategoryRepository.findYarnCategoryById(yarnDto.getCategoryId()));
        expected.setCountry(countryRepository.findById(yarnDto.getCountryId()).orElseThrow());
        expected.setPrice(yarnDto.getPrice());
        expected.setName(yarnDto.getName());

        assertEquals(expected.getCountry().getId(), yarnDto.getCountryId());
        assertEquals(expected.getCategory().getId(), yarnDto.getCategoryId());
    }

    @Test
    public void testGetAllYarns() {
        List<Yarn> yarns = new ArrayList<>();
        Yarn yarn1 = new Yarn();
        yarn1.setId(1L);
        yarn1.setName("Acrylic Yarn");
        yarn1.setColor("Blue");
        yarn1.setWeight(120);

        Yarn yarn2 = new Yarn();
        yarn2.setId(2L);
        yarn2.setName("Cotton Yarn");
        yarn2.setColor("Green");
        yarn2.setWeight(100);

        yarns.add(yarn1);
        yarns.add(yarn2);

        when(yarnRepository.findAll()).thenReturn(yarns);

        List<Yarn> result = yarnService.getAllYarns();

        assertEquals(2, result.size());
        assertEquals("Acrylic Yarn", result.get(0).getName());
        assertEquals("Blue", result.get(0).getColor());
        assertEquals("Worsted", result.get(0).getWeight());
        assertEquals("Cotton Yarn", result.get(1).getName());
        assertEquals("Green", result.get(1).getColor());
        assertEquals("Sport", result.get(1).getWeight());
    }

}