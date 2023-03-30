package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Yarn> orderedYarns;
    @ManyToMany
    private List<Accessory> orderedAccessories;
    @ManyToMany
    private List<Toy> orderedToys;

    @Column(nullable = false)
    private BigDecimal totalSumOfOrder;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDate orderCreated;
    @ManyToOne
    private YarnShopUser client;

    public Order() {
        orderedYarns = new ArrayList<>();
        orderedAccessories = new ArrayList<>();
        orderedToys = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Yarn> getOrderedYarns() {
        return orderedYarns;
    }

    public Order setOrderedYarns(List<Yarn> orderedYarns) {
        this.orderedYarns = orderedYarns;
        return this;
    }

    public List<Accessory> getOrderedAccessories() {
        return orderedAccessories;
    }

    public Order setOrderedAccessories(List<Accessory> orderedAccessories) {
        this.orderedAccessories = orderedAccessories;
        return this;
    }

    public List<Toy> getOrderedToys() {
        return orderedToys;
    }

    public Order setOrderedToys(List<Toy> orderedToys) {
        this.orderedToys = orderedToys;
        return this;
    }

    public BigDecimal getTotalSumOfOrder() {
        return totalSumOfOrder;
    }

    public Order setTotalSumOfOrder(BigDecimal totalSumOfOrder) {
        this.totalSumOfOrder = totalSumOfOrder;
        return this;
    }

    public LocalDate getOrderCreated() {
        return orderCreated;
    }

    public Order setOrderCreated(LocalDate orderCreated) {
        this.orderCreated = orderCreated;
        return this;
    }

    public YarnShopUser getClient() {
        return client;
    }

    public Order setClient(YarnShopUser client) {
        this.client = client;
        return this;
    }
}
