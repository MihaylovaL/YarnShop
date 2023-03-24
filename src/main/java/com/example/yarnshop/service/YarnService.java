package com.example.yarnshop.service;

import com.example.yarnshop.model.entity.Yarn;
import com.example.yarnshop.model.entity.YarnCategory;
import com.example.yarnshop.model.enums.Category;
import com.example.yarnshop.repository.YarnRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YarnService {
    private final YarnRepository yarnRepository;

    public YarnService(YarnRepository yarnRepository) {
        this.yarnRepository = yarnRepository;
    }

}
