package com.example.yarnshop.services;

import com.example.yarnshop.models.entities.UserRole;
import com.example.yarnshop.models.entities.YarnShopUser;
import com.example.yarnshop.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.
                findUserByEmail(email).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with name " + email + "not found!"));
    }
    private UserDetails map(YarnShopUser yarnShopUser) {
        return new User(yarnShopUser.getEmail(),
                yarnShopUser.getPassword(),
                extractAuthorities(yarnShopUser)
        );
    }
    private List<GrantedAuthority> extractAuthorities(YarnShopUser yarnShopUser) {
        return yarnShopUser.
                getRoles().
                stream().
                map(this::mapRole).
                toList();
    }

    private GrantedAuthority mapRole(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getRole().name());
    }
}
