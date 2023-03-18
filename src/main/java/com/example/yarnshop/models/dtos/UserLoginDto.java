package com.example.yarnshop.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    @Size(min = 5)
    @NotNull
    private String password;
    @NotNull
    @Size(min = 4, max = 15)
    private String username;

    public String getUsername() {
        return username;
    }

    public UserLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserLoginDto() {
    }
}
