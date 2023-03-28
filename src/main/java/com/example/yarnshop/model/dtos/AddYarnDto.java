package com.example.yarnshop.model.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddYarnDto {
    @NotNull
    @Size(min = 5, max = 20)
    private String name;
    @NotNull
    private String category;

    @NotNull
    @Size(min = 50, max = 1000)
    private Integer weight;

    @NotNull
    @Size(min = 50, max = 1000)
    private Integer length;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private String country;

    @NotNull
    private Integer size;

    @NotNull
    private String description;

    @NotNull
    private String color;
    @NotNull
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

    public String getCategory() {
        return category;
    }

    public AddYarnDto setCategory(String category) {
        this.category = category;
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

    public String getCountry() {
        return country;
    }

    public AddYarnDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public AddYarnDto setSize(Integer size) {
        this.size = size;
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
