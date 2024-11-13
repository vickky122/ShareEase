package com.example.Filesharingapp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String username;
  private String password;
  private String email;
  @Column(name = "verification_code", length = 64)
  private String verificationCode;

  private boolean enabled;

  @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL)
  private List<FileEntity> files;
}