package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
@Table(name = "accessories")

public class Accessory extends Product{
    @OneToOne
    private AccessoryCategory category;

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

    public AccessoryCategory getCategory() {
        return category;
    }

    public Accessory setCategory(AccessoryCategory category) {
        this.category = category;
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
