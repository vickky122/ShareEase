package com.example.Filesharingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Filesharingapp.entities.FileEntity;
import java.util.List;
import java.time.LocalDateTime;

public interface FileRepository extends JpaRepository<FileEntity, String> {
  // auto delete after 24 hours
  List<FileEntity> findByExpiryDateBefore(LocalDateTime now);

}
