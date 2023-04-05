package com.example.yarnshop.model.dtos.view;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProductWithInfoDto {
    private Long id;
    private String name;
    private String description;
    private String color;
    private BigDecimal price;
    private String imageUrl;
    @Positive
    @NotNull
    private Integer quantity;
    private BigDecimal sum;

    public ProductWithInfoDto() {
    }

    public Long getId() {
        return id;
    }

    public ProductWithInfoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductWithInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductWithInfoDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ProductWithInfoDto setColor(String color) {
        this.color = color;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductWithInfoDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductWithInfoDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductWithInfoDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public ProductWithInfoDto setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }
}
