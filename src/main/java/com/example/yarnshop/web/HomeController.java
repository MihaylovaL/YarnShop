package com.example.yarnshop.web;

import com.example.yarnshop.service.AccessoryCategoryService;
import com.example.yarnshop.service.YarnCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final YarnCategoryService yarnCategoryService;
    private final AccessoryCategoryService accessoryCategoryService;

    public HomeController(YarnCategoryService yarnCategoryService, AccessoryCategoryService accessoryCategoryService) {
        this.yarnCategoryService = yarnCategoryService;
        this.accessoryCategoryService = accessoryCategoryService;
    }

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("yarnCategory", yarnCategoryService.getAllYarnCategories());
        model.addAttribute("accessories", accessoryCategoryService.getAllAccessoryCategories());
        return "home";
    }
}
