package com.example.contact.Repositories;

import com.example.contact.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository
    extends JpaRepository<Contact, Long> {
}