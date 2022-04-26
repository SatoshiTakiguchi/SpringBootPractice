package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.app.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}