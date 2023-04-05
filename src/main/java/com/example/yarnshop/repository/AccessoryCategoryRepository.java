package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.AccessoryCategory;
import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.model.enums.AccessoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryCategoryRepository extends JpaRepository<AccessoryCategory, Long> {
    AccessoryCategory findAccessoryCategoryById(Long id);
    AccessoryCategory findByCategory(AccessoryEnum category);
}
