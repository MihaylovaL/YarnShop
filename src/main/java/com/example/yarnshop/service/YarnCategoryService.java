package com.example.yarnshop.service;

import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.repository.YarnCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YarnCategoryService {
    private final YarnCategoryRepository yarnCategoryRepository;

    public YarnCategoryService(YarnCategoryRepository yarnCategoryRepository) {
        this.yarnCategoryRepository = yarnCategoryRepository;
    }
    public List<YarnCategory> getAllYarnCategories(){
        return yarnCategoryRepository.findAll();
    }
}
