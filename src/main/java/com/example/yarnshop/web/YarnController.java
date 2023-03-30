package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddYarnDto;
import com.example.yarnshop.service.CountryService;
import com.example.yarnshop.service.YarnCategoryService;
import com.example.yarnshop.service.YarnService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String addYarn(@Valid AddYarnDto addYarnDto,
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

    @GetMapping("all")
    public String getAllYarns(Model model) {
        model.addAttribute("yarns", yarnService.getAllYarns());
        return "yarn";
    }
    @GetMapping("/info/{id}")
    public String yarnInfo (@PathVariable("id") Long id, Model model){
        model.addAttribute ("yarnInfo", this.yarnService.getProductInfoById(id));
        return "yarn-info";
    }


    @ModelAttribute("addYarnDto")
    public AddYarnDto initAddYarnDto() {
        return new AddYarnDto();
    }

}