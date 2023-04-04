package com.example.yarnshop.model.dtos.view;

import java.math.BigDecimal;

public class OrderDetailView {
    private Long id;
    private String clientFirstName;
    private String clientFullName;
    private String clientAddress;
    private String phoneNumber;
    private BigDecimal orderSum;

    public OrderDetailView() {
    }

    public Long getId() {
        return id;
    }

    public OrderDetailView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public OrderDetailView setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
        return this;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public OrderDetailView setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
        return this;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public OrderDetailView setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
        return this;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public OrderDetailView setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDetailView setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
