package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
@Table(name = "toys")
public class Toy extends Product {
    @Column(nullable = false)
    private Integer height;

    public Toy() {
    }

    public Integer getHeight() {
        return height;
    }

    public Toy setHeight(Integer height) {
        this.height = height;
        return this;
    }
}