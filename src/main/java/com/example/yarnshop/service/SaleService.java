package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.view.OrderDetailsDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.model.entity.BoughtProducts;
import com.example.yarnshop.model.entity.OrderDetails;
import com.example.yarnshop.model.entity.Sale;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.SaleRepository;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SaleRepository saleRepository;

    public SaleService(UserService userService, ModelMapper modelMapper, SaleRepository saleRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.saleRepository = saleRepository;
    }

    public void saleProducts(Principal principal, List<ProductWithInfoDto> products, OrderDetailsDto orderDetailsDto) {
        BigDecimal sumOfOrder = BigDecimal.ZERO;
        Sale sale = new Sale();
        List<BoughtProducts> boughtProducts = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCity(orderDetailsDto.getCity());
        orderDetails.setStreet(orderDetailsDto.getStreet());
        orderDetails.setPhoneNumber(orderDetailsDto.getPhoneNumber());

        for (ProductWithInfoDto product : products) {
            boughtProducts.add(modelMapper.map(product, BoughtProducts.class));
            BigDecimal productSum = product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
            sumOfOrder = sumOfOrder.add(productSum);

        }

        sale.setProducts(boughtProducts);
        sale.setDateOfOrder(LocalDate.now());
        sale.setUsername(principal.getName());
        sale.setOrderDetails(modelMapper.map(orderDetailsDto, OrderDetails.class));
        sale.setOrderSum(sumOfOrder);

        saleRepository.saveAndFlush(sale);
    }
}
