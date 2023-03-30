package com.example.yarnshop.model.dtos.view;

import java.math.BigDecimal;

public class ToyWithInfoView {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private String color;
    private BigDecimal price;
    private String imageUrl;

    public ToyWithInfoView() {
    }

    public Long getId() {
        return id;
    }

    public ToyWithInfoView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToyWithInfoView setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public ToyWithInfoView setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToyWithInfoView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ToyWithInfoView setColor(String color) {
        this.color = color;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ToyWithInfoView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ToyWithInfoView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
