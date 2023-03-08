package com.example.yarnshop.models.entities;

import com.example.yarnshop.models.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 6, max = 15)
    private String username;

    @Column(nullable = false, unique = true)
    @Size(min = 6, max = 15)
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
    private boolean isActive;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate created = LocalDate.now();

    @PastOrPresent
    private Date modified;

    @Enumerated(EnumType.ORDINAL)
    private UserRole role = UserRole.User;
    @ManyToOne
    private Country country;
}
