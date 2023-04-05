package com.example.services;

import com.example.yarnshop.model.dtos.UserRegisterDto;
import com.example.yarnshop.model.dtos.view.OrderDetailsDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.OrderDetails;
import com.example.yarnshop.model.entity.Sale;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.SaleRepository;
import com.example.yarnshop.service.SaleService;
import com.example.yarnshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class SaleServiceTest {

    private SaleService saleService;

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private SaleRepository saleRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        saleService = new SaleService(userService, modelMapper, saleRepository);
    }

    @Test
    void saleProducts_shouldSaveSale() {
        // Arrange
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("testUser");

        List<ProductWithInfoDto> products = new ArrayList<>();
        ProductWithInfoDto product1 = new ProductWithInfoDto();
        product1.setPrice(BigDecimal.TEN);
        product1.setQuantity(2);
        products.add(product1);

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setCity("New York");
        orderDetailsDto.setStreet("Test Street");
        orderDetailsDto.setPhoneNumber("123-456-7890");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCity("New York");
        orderDetails.setStreet("Test Street");
        orderDetails.setPhoneNumber("123-456-7890");

        when(modelMapper.map(orderDetailsDto, OrderDetails.class)).thenReturn(orderDetails);

        Sale expectedSale = new Sale();
        expectedSale.setOrderDetails(orderDetails);
        expectedSale.setOrderSum(BigDecimal.valueOf(20));
        expectedSale.setUsername("testUser");

        when(saleRepository.saveAndFlush(expectedSale)).thenReturn(expectedSale);

        // Act
        saleService.saleProducts(principal, products, orderDetailsDto);

        // Assert
        verify(modelMapper, times(1)).map(orderDetailsDto, OrderDetails.class);
    }


    @Test
    public void testDeleteOldOrders() {
        // Create a user


        // Create some sales to delete
        Sale sale1 = new Sale();
        sale1.setUsername("Admin");
        sale1.setDateOfOrder(LocalDate.now().minusYears(2));
        saleRepository.save(sale1);

        Sale sale2 = new Sale();
        sale2.setUsername("Admin");
        sale2.setDateOfOrder(LocalDate.now().minusYears(1));
        saleRepository.save(sale2);

        Sale sale3 = new Sale();
        sale3.setUsername("Admin");
        sale3.setDateOfOrder(LocalDate.now().minusMonths(6));
        saleRepository.save(sale3);

        saleRepository.deleteById(1L);

        // Call the method to delete old orders
        saleService.deleteOldOrders();

        // Verify that the correct sales were deleted
        List<Sale> remainingSales = saleRepository.findAll();
        assertEquals(0, remainingSales.size());
    }
}
