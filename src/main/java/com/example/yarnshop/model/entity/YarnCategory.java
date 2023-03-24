package com.example.yarnshop.model.entity;

import com.example.yarnshop.model.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "yarn_categories")
@AllArgsConstructor
public class YarnCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    public YarnCategory() {
    }

    public Long getId() {
        return id;
    }

    public YarnCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public YarnCategory setCategory(Category category) {
        this.category = category;
        return this;
    }
}
