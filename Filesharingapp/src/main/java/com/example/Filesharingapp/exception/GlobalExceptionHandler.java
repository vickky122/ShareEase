package com.example.Filesharingapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(FileNotFoundException.class)
  public ResponseEntity<?> handleFileNotFound(FileNotFoundException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(UserEmailNotFound.class)
  public ResponseEntity<?> handleCanvasNotFoundException(UserEmailNotFound e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ExceptionHandler(UserEmailAlraedyExists.class)
  public ResponseEntity<?> handleUserEmailAlraedyExist(UserEmailAlraedyExists e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}