package com.example.Filesharingapp.exception;

public class UserEmailAlraedyExists extends RuntimeException {
  public UserEmailAlraedyExists(String message) {
    super(message);
  }
}