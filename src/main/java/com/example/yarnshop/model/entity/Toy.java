package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
@Table(name = "toys")
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer height;
    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    @URL
    private String imageUrl;

    public Toy() {
    }

    public Long getId() {
        return id;
    }

    public Toy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Toy setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Toy setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Toy setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Toy setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Toy setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
