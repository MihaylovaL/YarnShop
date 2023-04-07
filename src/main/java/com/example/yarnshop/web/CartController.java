package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.view.OrderDetailView;
import com.example.yarnshop.model.dtos.view.OrderDetailsDto;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.service.ProductService;
import com.example.yarnshop.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CartController {
    private final ProductService productService;

    private List<ProductWithInfoDto> products;
    private BigDecimal totalSumOtItemsInTheCart = BigDecimal.ZERO;
    private final SaleService saleService;

    public CartController(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
        this.products = new ArrayList<>();
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("products", products);
        model.addAttribute("totalSum", totalSumOtItemsInTheCart);
        model.addAttribute("orderView", OrderDetailView.class);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute("product") @Valid ProductWithInfoDto product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Integer quantity) {
        boolean productAlreadyInCart = false;
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("product", product);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product");
            if (product.getName().equals("Himalaya")){
                return "redirect: /yarns/all";
        }
            else if(product.getName().equals("hook")){
                return "redirect: /accessories/all";
            }
            else{
                return "redirect: /toys/all";
            }
        }
        for (ProductWithInfoDto productWithInfoDto : products) {
            if (product.getName().equals(productWithInfoDto.getName())) {
                productWithInfoDto.setQuantity(productWithInfoDto.getQuantity() + quantity);
                productWithInfoDto.setSum(productWithInfoDto.getSum().multiply(BigDecimal.valueOf(productWithInfoDto.getQuantity())));
                productAlreadyInCart = true;
                break;
            }
        }
        if (!productAlreadyInCart) {
            product.setQuantity(quantity);
            products.add(product);
        }
        productService.addProductToCart(product, quantity);
        totalSumOtItemsInTheCart = products.stream()
                .map(ProductWithInfoDto::getSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "redirect:/";
    }

    @GetMapping("/cart/remove-product-from-list")
    String removeProductFromChoseList(@ModelAttribute("product") ProductWithInfoDto product) {
       products.remove(product);
        return "cart";
    }

    @GetMapping("/sale")
    public String getSale(@ModelAttribute("orderDetails") OrderDetailsDto orderDetails, Model model, Principal principal) {
        model.addAttribute("products", products);
        model.addAttribute("totalSum", totalSumOtItemsInTheCart);

        return "order-details";
    }

    @PostMapping("/sale")
    public String saleProducts(
            Principal principal, @ModelAttribute("orderDetails") OrderDetailsDto orderDetailsDto) {
        saleService.saleProducts(principal, products, orderDetailsDto);
        products.clear();
        totalSumOtItemsInTheCart = BigDecimal.ZERO;
        return "index";
    }
}
