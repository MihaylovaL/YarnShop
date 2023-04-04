package com.example.yarnshop.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "bought_products")
public class BoughtProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String color;
    private BigDecimal price;
    private String imageUrl;
    private Integer quantity;
    private BigDecimal sum;

    public BoughtProducts() {
    }

    public Long getId() {
        return id;
    }

    public BoughtProducts setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BoughtProducts setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BoughtProducts setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public BoughtProducts setColor(String color) {
        this.color = color;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BoughtProducts setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BoughtProducts setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BoughtProducts setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BoughtProducts setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }
}
