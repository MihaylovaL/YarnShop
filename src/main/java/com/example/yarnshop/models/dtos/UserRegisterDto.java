package com.example.yarnshop.models.dtos;

import com.example.yarnshop.models.entities.Country;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    @NotNull
    @Size(min = 6, max = 15)
    private String username;
    @NotNull
    @Size(min = 6, max = 15)
    private String password;
    @NotNull
    @Size(min = 6, max = 15)
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
}
