package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.view.OrderDetailView;
import com.example.yarnshop.model.dtos.view.ProductWithInfoDto;
import com.example.yarnshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CartController {
    private final ProductService productService;

    private List<ProductWithInfoDto> products;
    private BigDecimal totalSumOtItemsInTheCart;

    public CartController(ProductService productService) {
        this.productService = productService;
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
    public String addToCart(@ModelAttribute("product") ProductWithInfoDto product, Integer quantity) {
        boolean productAlreadyInCart = false;
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
        totalSumOtItemsInTheCart = products.stream ()
                .map (ProductWithInfoDto::getSum)
                .reduce (BigDecimal.ZERO, BigDecimal::add);

        return "redirect:/";
    }

    @GetMapping("/cart/remove-product-from-list")
    String removeProductFromChoseList(@ModelAttribute("product") ProductWithInfoDto product) {
        this.products.remove (product);
        return "cart";
    }

    /*@GetMapping("/order/details/{id}")
    public String placeOrder(@PathVariable("id") Long orderId,
                             Principal principal, Model model) {
        model.addAttribute ("orderDetails", this.products.getOrderDetailsById (principal, orderId));
        return "order-details";
    }*/
}
