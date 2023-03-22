package com.example.yarnshop.models.dtos;

import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.validations.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@PasswordMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDto {
    @NotNull
    @Size(min = 6, max = 15)
    private String username;
    @NotNull
    @Size(min = 6)
    private String password;
    @NotNull
    private String confirmPassword;

    @NotNull
    @Size(min = 6, max = 15)
    private String firstName;

    @NotNull
    @Size(min = 6, max = 15)
    private String lastName;

    @NotNull
    @Email
    private String email;
    @NotNull
    private Long countryId;

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public UserRegisterDto setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }
}
