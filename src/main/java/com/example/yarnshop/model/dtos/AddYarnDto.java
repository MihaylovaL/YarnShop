package com.example.yarnshop.model.dtos;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public class AddYarnDto {

    @Size(min = 5)
    private String name;

    @NotNull
    private Long categoryId;

    @NotNull
    @Min(50)
    @Max(1000)
    private Integer weight;

    @NotNull
    @Min(50)
    @Max(1000)
    private Integer length;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private Long countryId;


    @NotNull
    private String description;

    @NotNull
    private String color;
    @NotNull
    @URL
    private String image;

    public AddYarnDto() {
    }

    public String getName() {
        return name;
    }

    public AddYarnDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public AddYarnDto setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public AddYarnDto setLength(Integer length) {
        this.length = length;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddYarnDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public AddYarnDto setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public AddYarnDto setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddYarnDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AddYarnDto setColor(String color) {
        this.color = color;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AddYarnDto setImage(String image) {
        this.image = image;
        return this;
    }
}
