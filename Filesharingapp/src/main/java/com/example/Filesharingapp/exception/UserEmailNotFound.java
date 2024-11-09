package com.example.Filesharingapp.exception;

public class UserEmailNotFound extends RuntimeException {
  public UserEmailNotFound(String message) {
    super(message);
  }
}