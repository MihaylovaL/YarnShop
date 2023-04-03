package com.example.yarnshop.service;

public class SaleService {
    private final UserService userService;

    public SaleService(UserService userService) {
        this.userService = userService;
    }
}
