package com.example.yarnshop.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUserDetails extends User {

  private String country;
  private String username;

  public AppUserDetails(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public String getCountry() {
    return country;
  }

  public AppUserDetails setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public AppUserDetails setUsername(String username) {
    this.username = username;
    return this;
  }
}
