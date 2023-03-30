package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.AddToyDto;
import com.example.yarnshop.service.ToyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/toys")
public class ToyController {
    private final ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }


    @GetMapping("/add")
    public String getAddToy() {
        return "toy-add";
    }

    @PostMapping("/add")
    public String addToys(@Valid AddToyDto addToyDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addToyDto", addToyDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addToyDto", bindingResult);

            return "redirect:toy-add";
        }
        toyService.addToy(addToyDto);
        return "index";
    }

    @GetMapping("all")
    public String getAllAccessories(Model model) {
        model.addAttribute("toys", toyService.getAllToys());
        return "toy";
    }
    @GetMapping("/info/{id}")
    public String accessoryInfo (@PathVariable("id") Long id, Model model){
        model.addAttribute ("toyInfo", this.toyService.getProductInfoById(id));
        return "toy-info";
    }


    @ModelAttribute("addToyDto")
    public AddToyDto initAddToyDto() {
        return new AddToyDto();
    }

}
