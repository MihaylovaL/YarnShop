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

    @ManyToMany
    private List<BoughtProducts> products = new ArrayList<>();

    @ManyToOne
    private YarnShopUser client;
    @Column
    private LocalDate dateOfOrder;

    @Column(name = "order_sum")
    private BigDecimal orderSum;

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

    public YarnShopUser getClient() {
        return client;
    }

    public Sale setClient(YarnShopUser client) {
        this.client = client;
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
}
