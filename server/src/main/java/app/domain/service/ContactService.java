package app.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.domain.repository.ContactRepository;
import app.domain.entity.Contact;

import java.util.List;
import java.util.Optional;

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

    public void save(Contact Contact) {
        //更新
        repository.save(Contact);
    }

    public void deleteById(Long id) {
        //削除
        repository.deleteById(id);
    }
}
