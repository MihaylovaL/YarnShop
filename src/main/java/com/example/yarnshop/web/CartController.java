package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CartController {
    private final ProductService productService;

    private List<ProductWithInfoDto> products;

    public CartController(ProductService productService) {
        this.productService = productService;
        this.products = new ArrayList<>();
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("products", products);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute("product") ProductWithInfoDto product) {
        productService.addProductToCart(product);
        products.add(product);
        return "redirect:/";
    }

  /*  @ModelAttribute("products")
    public ProductWithInfoDto product(){
        return new ProductWithInfoDto();
    }*/
}
