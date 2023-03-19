package com.example.yarnshop.web;

import com.example.yarnshop.models.dtos.UserRegisterDto;
import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.services.CountryService;
import com.example.yarnshop.services.UserService;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private CountryService countryService;
    private final SecurityContextRepository securityContextRepository;

    public UserController(UserService userService, CountryService countryService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.countryService = countryService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        List<Country> all = countryService.findAll();
        model.addAttribute("countries", all);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(UserRegisterDto userRegisterDto) {
        userService.registerUser(userRegisterDto);
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }
}
