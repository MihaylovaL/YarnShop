package com.example.yarnshop.web;

import com.example.yarnshop.model.dtos.view.ToyWithInfoView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private List<ToyWithInfoView> toys;

    public CartController() {
        this.toys = new ArrayList<>();
    }

    @GetMapping("/add")
    public String getCart(Model model) {
        return "cart";
    }
}
