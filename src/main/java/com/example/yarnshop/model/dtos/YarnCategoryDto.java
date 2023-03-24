package com.example.yarnshop.model.dtos;


import com.example.yarnshop.model.enums.Category;
import jakarta.persistence.Enumerated;

public class YarnCategoryDto {
    @Enumerated
   private Category category;

    public YarnCategoryDto() {
    }

    public Category getCategory() {
        return category;
    }

    public YarnCategoryDto setCategory(Category category) {
        this.category = category;
        return this;
    }
}
