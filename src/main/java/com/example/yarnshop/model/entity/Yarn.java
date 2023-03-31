package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
@Table(name = "yarns")

public class Yarn extends Product {
    @OneToOne
    private YarnCategory category;

    @Column(nullable = false)
    @Min(50)
    @Max(1000)
    private Integer weight;

    @Column(nullable = false)
    @Min(50)
    @Max(1000)
    private Integer length;
    @ManyToOne
    private Country country;


    @ManyToOne
    private Review review;

    @Column(nullable = false)
    private String color;

    public Yarn() {
    }

    public YarnCategory getCategory() {
        return category;
    }

    public Yarn setCategory(YarnCategory category) {
        this.category = category;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Yarn setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public Yarn setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Yarn setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Review getReview() {
        return review;
    }

    public Yarn setReview(Review review) {
        this.review = review;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Yarn setColor(String color) {
        this.color = color;
        return this;
    }
}
