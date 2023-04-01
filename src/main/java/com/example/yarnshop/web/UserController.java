package com.example.yarnshop.web;

import com.example.yarnshop.service.AccessoryService;
import com.example.yarnshop.service.ToyService;
import com.example.yarnshop.service.UserService;
import com.example.yarnshop.service.YarnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
private final UserService userService;
private final ToyService toyService;
private final YarnService yarnService;
private final AccessoryService accessoryService;

    public UserController(UserService userService, ToyService toyService, YarnService yarnService, AccessoryService accessoryService) {
        this.userService = userService;
        this.toyService = toyService;
        this.yarnService = yarnService;
        this.accessoryService = accessoryService;
    }


    @GetMapping("/admin")
    public String adminPanel(Model model){
        model.addAttribute ("allUsers", this.userService.getAllUsers());
        model.addAttribute ("allToys", this.toyService.getAllToys ());
        model.addAttribute ("allYarns", this.yarnService.getAllYarns ());
        model.addAttribute ("allAccessories", this.accessoryService.getAllYarns());
        return "admin";
    }
}
