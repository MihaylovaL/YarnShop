package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.service.AccessoryCategoryService;
import com.example.yarnshop.service.AccessoryService;
import com.example.yarnshop.service.CountryService;
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
@RequestMapping("/accessories")
public class AccessoryController {
    private final AccessoryCategoryService accessoryCategoryService;
    private final CountryService countryService;
    private final AccessoryService accessoryService;

    public AccessoryController(AccessoryCategoryService accessoryCategoryService, CountryService countryService, AccessoryService accessoryService) {
        this.accessoryCategoryService = accessoryCategoryService;
        this.countryService = countryService;
        this.accessoryService = accessoryService;
    }


    @GetMapping("/add")
    public String getAddProduct(Model model) {
        model.addAttribute("categories", accessoryCategoryService.getAllAccessoryCategories());
        model.addAttribute("countries", countryService.findAll());
        return "accessory-add";
    }

    @PostMapping("/add")
    public String addProducts(@Valid AddAccessoryDto accessoryDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("accessoryDto", accessoryDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.accessoryDto", bindingResult);

            return "redirect:accessory-add";
        }
        accessoryService.addAccessory(accessoryDto);
        return "index";
    }


    @ModelAttribute("accessoryDto")
    public AddAccessoryDto initAddProductDTO() {
        return new AddAccessoryDto();
    }

}
