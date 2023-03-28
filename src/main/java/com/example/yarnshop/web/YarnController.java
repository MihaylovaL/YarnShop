package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.service.YarnCategoryService;
import com.example.yarnshop.service.YarnService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class YarnController {
    private final YarnService yarnService;
    private final YarnCategoryService yarnCategoryService;

    public YarnController(YarnService yarnService, YarnCategoryService yarnCategoryService) {
        this.yarnService = yarnService;
        this.yarnCategoryService = yarnCategoryService;
    }

    @GetMapping("/add")
    public String getAddProduct(Model model) {
        model.addAttribute("categories", yarnCategoryService.getAllYarnCategories());
        return "product-add";
    }

    @PostMapping("/add")
    public String addProducts(@Valid @ModelAttribute("addYarnDto") AddYarnDto addYarnDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addYarnDto", addYarnDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addYarnDto", bindingResult);

            return "redirect:/products/add";
        }
        yarnService.addYarn(addYarnDto);
        return "redirect: /";
    }


    @ModelAttribute("addYarnDto")
    public AddYarnDto initAddProductDTO() {
        return new AddYarnDto();
    }

}
