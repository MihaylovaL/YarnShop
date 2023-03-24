package com.example.yarnshop.model.entity;

import com.example.yarnshop.model.enums.AccessoryEnum;
import com.example.yarnshop.model.enums.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "accessory_categories")
public class AccessoryCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AccessoryEnum category;

    public AccessoryCategory() {
    }

    public Long getId() {
        return id;
    }

    public AccessoryCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public AccessoryEnum getCategory() {
        return category;
    }

    public AccessoryCategory setCategory(AccessoryEnum category) {
        this.category = category;
        return this;
    }
}
