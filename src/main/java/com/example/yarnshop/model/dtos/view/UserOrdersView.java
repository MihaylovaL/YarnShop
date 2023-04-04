package com.example.yarnshop.model.dtos.view;

import com.example.yarnshop.model.entity.Review;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class UserOrdersView {
    private Long id;
    private LocalDate dateOrdered;
    private BigDecimal orderSum;
    private List<ProductWithInfoDto> saleProducts;
    private Review review;

    public UserOrdersView() {
    }

    public Long getId() {
        return id;
    }

    public UserOrdersView setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public UserOrdersView setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
        return this;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public UserOrdersView setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
        return this;
    }

    public List<ProductWithInfoDto> getSaleProducts() {
        return saleProducts;
    }

    public UserOrdersView setSaleProducts(List<ProductWithInfoDto> saleProducts) {
        this.saleProducts = saleProducts;
        return this;
    }

    public Review getReview() {
        return review;
    }

    public UserOrdersView setReview(Review review) {
        this.review = review;
        return this;
    }
}
