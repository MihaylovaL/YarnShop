package com.example.yarnshop.models.entities;

import com.example.yarnshop.models.enums.AccessoryCategory;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Enumerated(EnumType.ORDINAL)
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
}
