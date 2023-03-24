package com.example.yarnshop.service;

import com.example.yarnshop.model.AppUserDetails;

import java.util.List;

import com.example.yarnshop.model.entity.UserRole;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public ApplicationUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return
        userRepository.
            findUserByEmail(username).
            map(this::map).
            orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
  }

  private UserDetails map(YarnShopUser user) {
    return new AppUserDetails(
            user.getEmail(),
            user.getPassword(),
        extractAuthorities(user)
    ).
        setCountry(String.valueOf(user.getCountry())).
        setUsername(user.getUsername());
  }

  private List<GrantedAuthority> extractAuthorities(YarnShopUser user) {
    return user.
        getRoles().
        stream().
        map(this::mapRole).
        toList();
  }

  private GrantedAuthority mapRole(UserRole userRoleEntity) {
    return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
  }
}
