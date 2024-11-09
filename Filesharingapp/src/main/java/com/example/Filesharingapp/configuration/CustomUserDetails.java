package com.example.Filesharingapp.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Filesharingapp.entities.UserInfo;

public class CustomUserDetails implements UserDetails {

  private String email;
  private String password;
  private List<GrantedAuthority> authorities;
  private boolean enabled;

  public CustomUserDetails(UserInfo userInfo) {
    this.email = userInfo.getEmail();
    this.password = userInfo.getPassword();
    this.authorities = null;
    this.enabled = userInfo.isEnabled();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

}