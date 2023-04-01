package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddAccessoryDto;
import com.example.yarnshop.model.dtos.view.ToyWithInfoView;
import com.example.yarnshop.service.AccessoryCategoryService;
import com.example.yarnshop.service.AccessoryService;
import com.example.yarnshop.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String getAddAccessories(Model model) {
        model.addAttribute("categories", accessoryCategoryService.getAllAccessoryCategories());
        model.addAttribute("countries", countryService.findAll());
        return "accessory-add";
    }

    @PostMapping("/add")
    public String addAccessories(@Valid AddAccessoryDto accessoryDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("accessoryDto", accessoryDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.accessoryDto", bindingResult);

            return "redirect: accessory-add";
        }
        accessoryService.addAccessory(accessoryDto);
        return "index";
    }

    @GetMapping("all")
    public String getAllAccessories(Model model) {
        model.addAttribute("accessories", accessoryService.getAllYarns());
        return "accessory";
    }
    @GetMapping("/info/{id}")
    public String accessoryInfo (@PathVariable("id") Long id, Model model){
        model.addAttribute ("accessoryInfo", this.accessoryService.getProductInfoById(id));
        return "accessory-info";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long accessoryId, Model model){
        model.addAttribute("accessoryToEdit", this.accessoryService.getProductInfoById(accessoryId));
        return "accessory-edit";
    }

    @PatchMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long productId,
                              @Valid ToyWithInfoView editAccessoryDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("editAccessoryDto", editAccessoryDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.editAccessoryDto", bindingResult);

            return "redirect:/accessories/edit/" + productId;
        }

        this.accessoryService.editProduct(productId, editAccessoryDto);
        return "redirect:/users/admin";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        this.accessoryService.deleteProductById(productId);
        return "redirect:/users/admin";
    }




    @ModelAttribute("accessoryDto")
    public AddAccessoryDto initAddAccessory() {
        return new AddAccessoryDto();
    }

}
