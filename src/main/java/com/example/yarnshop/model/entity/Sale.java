package com.example.yarnshop.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<BoughtProducts> products = new ArrayList<>();

    private String username;
    @Column
    private LocalDate dateOfOrder;

    @Column(name = "order_sum")
    private BigDecimal orderSum;
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderDetails orderDetails;

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public Sale setId(Long id) {
        this.id = id;
        return this;
    }

    public List<BoughtProducts> getProducts() {
        return products;
    }

    public Sale setProducts(List<BoughtProducts> products) {
        this.products = products;
        return this;
    }


    public String getUsername() {
        return username;
    }

    public Sale setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public Sale setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
        return this;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public Sale setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
        return this;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public Sale setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }
}
