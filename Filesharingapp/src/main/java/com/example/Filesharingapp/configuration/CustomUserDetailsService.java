package com.example.Filesharingapp.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Filesharingapp.entities.UserInfo;
import com.example.Filesharingapp.repository.UserInfoRepository;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<UserInfo> userInfo = userInfoRepository.findByEmail(email);
    if (userInfo.isPresent()) {
      return new CustomUserDetails(userInfo.get());
    } else {
      throw new UsernameNotFoundException("User not found");
    }
  }

}