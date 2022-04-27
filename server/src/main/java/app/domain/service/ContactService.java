package app.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.domain.repository.ContactRepository;
import app.domain.entity.Contact;
import app.domain.form.ContactForm;

import java.util.List;
import java.util.Optional;

// import javax.swing.text.AbstractDocument.Content;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repository;

    public List<Contact> getAll() {
        //全件取得
        return repository.findAll();
    }

    public Optional<Contact> getById(Long id) {
        //IDで検索
        return repository.findById(id);
    }

    public void save(ContactForm contact_form) {
        Contact contact = new Contact();
        contact.setName(contact_form.getName());
        contact.setEmail(contact_form.getEmail());
        contact.setContent(contact_form.getContent());
        repository.save(contact);
    }

    public void deleteById(Long id) {
        //削除
        repository.deleteById(id);
    }
}
