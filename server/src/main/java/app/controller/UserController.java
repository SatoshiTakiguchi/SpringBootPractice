package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import app.domain.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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