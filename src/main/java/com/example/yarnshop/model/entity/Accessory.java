package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "accessories")

public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String name;

    @Column
    private String imageUrl;

    @OneToOne
    private AccessoryCategory category;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private String material;

    @ManyToOne
    private Country country;

    @Column(nullable = false)
    private String size;

    @ManyToOne
    private Review review;

    @Column(nullable = false)
    private String color;

    public Accessory() {
    }

    public Long getId() {
        return id;
    }

    public Accessory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accessory setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Accessory setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public AccessoryCategory getCategory() {
        return category;
    }

    public Accessory setCategory(AccessoryCategory category) {
        this.category = category;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Accessory setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Accessory setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public Accessory setMaterial(String material) {
        this.material = material;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Accessory setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Accessory setSize(String size) {
        this.size = size;
        return this;
    }

    public Review getReview() {
        return review;
    }

    public Accessory setReview(Review review) {
        this.review = review;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Accessory setColor(String color) {
        this.color = color;
        return this;
    }
}
