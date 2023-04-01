package com.example.yarnshop.model.dtos.view;

import java.math.BigDecimal;

public class ProductWithInfoDto {
    private Long id;
    private String name;
    private String description;
    private String color;
    private BigDecimal price;
    private String imageUrl;

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
}