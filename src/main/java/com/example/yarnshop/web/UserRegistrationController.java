package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.UserRegisterDto;
import com.example.yarnshop.model.entity.Country;
import com.example.yarnshop.service.CountryService;
import com.example.yarnshop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;
    private final CountryService countryService;

    public UserRegistrationController(UserService userService,
                                      SecurityContextRepository securityContextRepository, CountryService countryService) {
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
        this.countryService = countryService;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        List<Country> all = countryService.findAll();
        model.addAttribute("countries", all);
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerNewUser(
            @Valid @ModelAttribute("userRegisterDto") UserRegisterDto registrationDTO,
             BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request,
            HttpServletResponse response) {

            if(bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto())
                        .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto");
                return "auth-register";
            }

        userService.registerUser(registrationDTO, successfulAuth -> {
            // populating security context
            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

            SecurityContext context = strategy.createEmptyContext();
            context.setAuthentication(successfulAuth);

            strategy.setContext(context);

            securityContextRepository.saveContext(context, request, response);
        });

        return "redirect:/";
    }
    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }
}
