package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
@MappedSuperclass
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @Column(nullable = false)
    @URL
    String imageUrl;
    @Column(nullable = false, columnDefinition = "TEXT")
    String description;
    @Column(nullable = false)
    @Positive
    BigDecimal price;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Product setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
