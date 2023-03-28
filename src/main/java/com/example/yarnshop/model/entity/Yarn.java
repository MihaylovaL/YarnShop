package com.example.yarnshop.model.entity;

import com.example.yarnshop.model.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "yarns")

public class Yarn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String name;
    @OneToOne
    private YarnCategory category;

    @Column(nullable = false)
    @Size(min = 50, max = 1000)
    private Integer weight;

    @Column(nullable = false)
    @Size(min = 50, max = 1000)
    private Integer length;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @ManyToOne
    private Country country;

    @Column(nullable = false)
    private Integer size;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    private Review review;

    @Column(nullable = false)
    private String color;
    @Column(nullable = false, unique = true)
    private String image;

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

    public Integer getSize() {
        return size;
    }

    public Yarn setSize(Integer size) {
        this.size = size;
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

    public String getImage() {
        return image;
    }

    public Yarn setImage(String image) {
        this.image = image;
        return this;
    }
}
