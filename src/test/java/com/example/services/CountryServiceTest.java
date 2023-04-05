package com.example.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.example.yarnshop.model.entity.Country;
import com.example.yarnshop.repository.CountryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.yarnshop.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CountryServiceTest {
    @Mock
    private CountryRepository countryRepository;

    private CountryService countryService;

    @BeforeEach
    void setUp() {
            MockitoAnnotations.openMocks(this);
            this.countryService = new CountryService(countryRepository);
    }

    @Test
    @DisplayName("Test findByName() with valid countryId")
    void testFindByNameWithValidId() {
        // Arrange
        Long countryId = 1L;
        Country expectedCountry = new Country();
        expectedCountry.setId(countryId);
        expectedCountry.setName("Test Country");
        when(countryRepository.findById(countryId)).thenReturn(Optional.of(expectedCountry));

        // Act
        Country actualCountry = countryService.findByName(countryId);

        // Assert
        assertThat(actualCountry).isNotNull();
        assertThat(actualCountry).isEqualTo(expectedCountry);
    }

    @Test
    @DisplayName("Test findByName() with invalid countryId")
    void testFindByNameWithInvalidId() {
        // Arrange
        Long countryId = 1L;
        when(countryRepository.findById(countryId)).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(RuntimeException.class, () -> countryService.findByName(countryId));
    }

    @Test
    @DisplayName("Test findAll()")
    void testFindAll() {
        // Arrange
        Country country1 = new Country();
        country1.setId(1L);
        country1.setName("Country 1");

        Country country2 = new Country();
        country2.setId(2L);
        country2.setName("Country 2");

        when(countryRepository.findAll()).thenReturn(Arrays.asList(country1, country2));

        // Act
        List<Country> actualCountries = countryService.findAll();

        // Assert
        assertThat(actualCountries).hasSize(2);
        assertThat(actualCountries).containsExactlyInAnyOrder(country1, country2);
    }
}