package com.example.Filesharingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()

public class fileController {
  @GetMapping("/files")
  public String login() {
    return "home";
  }

  @GetMapping("/list")
  public String list() {
    return "list-files";
  }

  @GetMapping("/share")
  public String share() {
    return "share-file";
  }

}
