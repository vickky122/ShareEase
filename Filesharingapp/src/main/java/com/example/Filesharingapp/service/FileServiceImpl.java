package com.example.Filesharingapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Filesharingapp.entities.FileEntity;
import com.example.Filesharingapp.model.FileModel;
import com.example.Filesharingapp.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    // entity to model so that responses can be accessed from backend to the
    // frontend
    private FileModel convertToModel(FileEntity entity) {
        FileModel model = new FileModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    @Override
    public List<FileModel> getAll() {
        List<FileEntity> entityList = fileRepository.findAll();
        return entityList.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy) throws IOException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setUploadedBy(uploadedBy);
        fileEntity.setUploadTime(LocalDateTime.now());
        fileEntity.setExpiryTime(LocalDateTime.now().plusDays(1)); // 24 hours expiry
        // fileEntity.setUserInfo(user);
        fileEntity.setFileData(file.getBytes());
        fileRepository.save(fileEntity);
        FileModel fileModel = new FileModel();
        BeanUtils.copyProperties(fileEntity, fileModel);
        return ResponseEntity.ok().body(fileModel);
    }

    @Override
    public ResponseEntity<?> shareFile(int id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'shareFile'");
        Optional<FileEntity> fileEntity = fileRepository.findById(id);
        if (fileEntity.isPresent()) {
            FileEntity file = fileEntity.get();
            FileModel fileModel = new FileModel();
            BeanUtils.copyProperties(file, fileModel);
            return ResponseEntity.ok().body(fileModel);
        } else {
            throw new FileNotFoundException("File not found");
        }
    }

    @Override
    public ResponseEntity<?> deleteFile(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }

}