package com.example.yarnshop.web;

import com.example.yarnshop.model.AppUserDetails;
import com.example.yarnshop.service.AccessoryCategoryService;
import com.example.yarnshop.service.YarnCategoryService;
import com.example.yarnshop.service.YarnService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final YarnCategoryService yarnCategoryService;
    private final AccessoryCategoryService accessoryCategoryService;
    private final YarnService yarnService;

    public HomeController(YarnCategoryService yarnCategoryService, AccessoryCategoryService accessoryCategoryService, YarnService yarnService) {
        this.yarnCategoryService = yarnCategoryService;
        this.accessoryCategoryService = accessoryCategoryService;
        this.yarnService = yarnService;
    }

    @GetMapping("/")
    public String getHome(@AuthenticationPrincipal AppUserDetails appUserDetails, Model model){
        /*model.addAttribute("yarnCategories", yarnCategoryService.getAllYarnCategories());
        model.addAttribute("accessories", accessoryCategoryService.getAllAccessoryCategories());*/
        model.addAttribute("yarns", yarnService.getAllYarns());
        if (appUserDetails != null) {
            model.addAttribute("username", appUserDetails.getUsername());
        }
        return "index";
    }
}
