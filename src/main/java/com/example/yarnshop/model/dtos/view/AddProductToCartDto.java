package com.example.yarnshop.model.dtos.view;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public class AddProductToCartDto {
    String name;
    @NotNull
    @URL
    String imageUrl;
    @NotNull
    String description;
    @NotNull
    @Positive
    BigDecimal price;

    public AddProductToCartDto() {
    }

    public String getName() {
        return name;
    }

    public AddProductToCartDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddProductToCartDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddProductToCartDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductToCartDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
