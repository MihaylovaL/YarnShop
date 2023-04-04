package com.example.yarnshop.model.dtos;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public class AddAccessoryDto {
    @NotNull
    @Size(min = 5)
    private String name;
    @OneToOne
    private Long categoryId;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private String description;

    @NotNull
    private String material;

    @NotNull
    private Long countryId;

    @NotNull
    private String size;

    @NotNull
    private String color;
    @NotNull
    @URL
    private String imageUrl;

    @Positive
    private Integer quantity;

    public AddAccessoryDto() {
    }

    public String getName() {
        return name;
    }

    public AddAccessoryDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public AddAccessoryDto setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddAccessoryDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddAccessoryDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public AddAccessoryDto setMaterial(String material) {
        this.material = material;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public AddAccessoryDto setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getSize() {
        return size;
    }

    public AddAccessoryDto setSize(String size) {
        this.size = size;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AddAccessoryDto setColor(String color) {
        this.color = color;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddAccessoryDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public AddAccessoryDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
