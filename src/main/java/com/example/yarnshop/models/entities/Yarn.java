package com.example.yarnshop.models.entities;

import com.example.yarnshop.models.enums.YarnCategory;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Yarn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String name;

    @Enumerated(EnumType.ORDINAL)
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
}
