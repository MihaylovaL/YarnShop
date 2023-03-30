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

public class Yarn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5)
    private String name;
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

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @ManyToOne
    private Country country;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    private Review review;

    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    @URL
    private String imageUrl;

    public Yarn() {
    }

    public Long getId() {
        return id;
    }

    public Yarn setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Yarn setName(String name) {
        this.name = name;
        return this;
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

    public BigDecimal getPrice() {
        return price;
    }

    public Yarn setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Yarn setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Yarn setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public Yarn setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
