package com.example.yarnshop.model.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public class AddToyDto {
    @NotNull
    private String name;
    @NotNull
    private Integer height;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private String description;
    @NotNull

    private String image;

    public AddToyDto() {
    }

    public String getName() {
        return name;
    }

    public AddToyDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public AddToyDto setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddToyDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddToyDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AddToyDto setImage(String image) {
        this.image = image;
        return this;
    }
}
