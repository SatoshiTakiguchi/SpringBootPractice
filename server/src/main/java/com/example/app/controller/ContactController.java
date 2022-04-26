package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.app.repository.ContactRepository;

@Controller
public class ContactController {

  private final ContactRepository repository;

  @Autowired
  public ContactController(ContactRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/contacts")
  public String users(Model model) {
    model.addAttribute("contacts", repository.findAll());
    return "contacts";
  }

}