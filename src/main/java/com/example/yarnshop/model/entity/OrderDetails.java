package com.example.yarnshop.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String phoneNumber;

    public OrderDetails() {
    }

    public Long getId() {
        return id;
    }

    public OrderDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderDetails setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public OrderDetails setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
