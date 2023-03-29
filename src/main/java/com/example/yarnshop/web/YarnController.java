package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.service.CountryService;
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
@RequestMapping("/yarns")
public class YarnController {
    private final YarnService yarnService;
    private final YarnCategoryService yarnCategoryService;
    private final CountryService countryService;

    public YarnController(YarnService yarnService, YarnCategoryService yarnCategoryService, CountryService countryService) {
        this.yarnService = yarnService;
        this.yarnCategoryService = yarnCategoryService;
        this.countryService = countryService;
    }

    @GetMapping("/add")
    public String getAddProduct(Model model) {
        model.addAttribute("categories", yarnCategoryService.getAllYarnCategories());
        model.addAttribute("countries", countryService.findAll());
        return "yarn-add";
    }

    @PostMapping("/add")
    public String addProducts(@Valid AddYarnDto addYarnDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addYarnDto", addYarnDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addYarnDto", bindingResult);

            return "redirect:yarn-add";
        }
        yarnService.addYarn(addYarnDto);
        return "index";
    }


    @ModelAttribute("addYarnDto")
    public AddYarnDto initAddProductDTO() {
        return new AddYarnDto();
    }

}
