package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.app.repository.UserRepository;

@Controller
public class UserController {

  private final UserRepository repository;

  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/users")
  public String users(Model model) {
    model.addAttribute("users", repository.findAll());
    return "users";
  }

}