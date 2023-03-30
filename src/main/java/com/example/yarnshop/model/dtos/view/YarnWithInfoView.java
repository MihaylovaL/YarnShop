package com.example.yarnshop.model.dtos.view;

import java.math.BigDecimal;

public class YarnWithInfoView {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private String color;
    private BigDecimal price;
    private String imageUrl;

    public YarnWithInfoView() {
    }

    public Long getId() {
        return id;
    }

    public YarnWithInfoView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public YarnWithInfoView setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public YarnWithInfoView setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public YarnWithInfoView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public YarnWithInfoView setColor(String color) {
        this.color = color;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public YarnWithInfoView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public YarnWithInfoView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
