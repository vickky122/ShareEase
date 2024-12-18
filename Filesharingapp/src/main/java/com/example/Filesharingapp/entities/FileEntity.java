package com.example.Filesharingapp.entities;

import java.time.LocalDateTime;
import java.util.UUID;

// import org.hsqldb.lib.RCData;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String fileName;
  private String uploadedBy;
  private LocalDateTime uploadTime;
  private LocalDateTime expiryTime;


  @Lob
  @Column(name = "file_data", columnDefinition="LONGBLOB")
  private byte[] fileData;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false) // Foreign key column in FileEntity table
  private UserInfo userInfo;




}