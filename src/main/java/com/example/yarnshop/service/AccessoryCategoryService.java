package com.example.yarnshop.service;

import com.example.yarnshop.model.entity.AccessoryCategory;
import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.repository.AccessoryCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryCategoryService {
    private final AccessoryCategoryRepository accessoryCategoryRepository;

    public AccessoryCategoryService(AccessoryCategoryRepository accessoryCategoryRepository) {
        this.accessoryCategoryRepository = accessoryCategoryRepository;
    }
    public List<AccessoryCategory> getAllAccessoryCategories(){
        return accessoryCategoryRepository.findAll();
    }
}
