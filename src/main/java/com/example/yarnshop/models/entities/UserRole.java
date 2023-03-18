package com.example.yarnshop.models.entities;

import com.example.yarnshop.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }

    public UserRole() {
    }
}
