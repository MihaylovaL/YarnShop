package com.example.yarnshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class YarnShopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 15)
    private String username;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false)
    @Size(min = 4, max = 15)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 4, max = 15)
    private String lastName;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate created = LocalDate.now();

    @PastOrPresent
    private Date modified;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRole> roles = new ArrayList<>();

    @ManyToOne
    private Country country;

    public Long getId() {
        return id;
    }

    public YarnShopUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public YarnShopUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public YarnShopUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public YarnShopUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public YarnShopUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public YarnShopUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public YarnShopUser setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public YarnShopUser setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public YarnShopUser setRoles(List<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public YarnShopUser setCountry(Country country) {
        this.country = country;
        return this;
    }

    public YarnShopUser() {
    }
}
