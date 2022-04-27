package app.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.domain.entity.Contact;
import app.domain.service.ContactService;
import app.domain.form.ContactForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // 一覧
    @RequestMapping("/master")
    public String contacts(Model model) {
      List<Contact> contact_list = contactService.getAll();
      model.addAttribute("contacts", contact_list);
      return "Contact/master";
    }

    // 詳細ページ
    // @GetMapping("/{id}")
    // public String getById(@PathVariable("id") Long id, Model model) {
    //     //IDで検索
    //     Optional<Contact> contact = contactService.getById(id);
    //     model.addAttribute("contact", contact);
    //     return "Contact/master";
    // }

    // 追加
    @GetMapping("")
    public String form(Model model) {
        model.addAttribute("contact_form", new ContactForm());
        return "Contact/new";
    }

    // 確認
    @PostMapping("/confirm")
    public String confirm(ContactForm contact_form, Model model) {
        model.addAttribute("contact_form", contact_form);
        return "Contact/confirm";
    }

    // 保存
    @PostMapping("/new")
    public String add(ContactForm contact_form) {
        contactService.save(contact_form);
        return "redirect:/contacts/master";
    }

    // 編集
    // @PostMapping("/edit")
    // public String edit(@ModelAttribute Contact contact) {
    //     contactService.save(contact);
    //     return "redirect:/contacts";
    // }


    //削除
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        contactService.deleteById(id);
        return "redirect:/contacts";
    }

}