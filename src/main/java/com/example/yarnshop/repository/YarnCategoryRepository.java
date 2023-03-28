package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YarnCategoryRepository extends JpaRepository<YarnCategory, Long> {
    YarnCategory findByCategory(Category category);
}
