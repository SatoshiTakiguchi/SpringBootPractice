package app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.domain.entity.Contact;
import app.domain.service.ContactService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/")
    public String contacts(@ModelAttribute Contact contacts, Model model) {
      List<Contact> contact_list = contactService.getAll();
      model.addAttribute("contacts", contact_list);
      return "Contact/contacts";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        //IDで検索
        Optional<Contact> contact = contactService.getById(id);
        model.addAttribute("contact", contact);
        return "Contact/contacts";
    }

    // 追加
    @PostMapping("/new")
    public String add(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    // 編集
    @PostMapping("/edit")
    public String edit(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }


    //削除
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        contactService.deleteById(id);
        return "redirect:/contacts";
    }

}