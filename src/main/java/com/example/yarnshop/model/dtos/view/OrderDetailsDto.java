package com.example.yarnshop.model.dtos.view;

import jakarta.validation.constraints.NotNull;

public class OrderDetailsDto {
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String phoneNumber;

    public OrderDetailsDto() {
    }

    public String getCity() {
        return city;
    }

    public OrderDetailsDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public OrderDetailsDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDetailsDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
