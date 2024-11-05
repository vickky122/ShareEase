package com.example.Filesharingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Filesharingapp.entities.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
  // auto delete after 20 hours

}
