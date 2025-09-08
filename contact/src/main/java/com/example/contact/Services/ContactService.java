package com.example.contact.Services;

import com.example.contact.Models.Contact;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> listar() {
        return contacts;
    }

    public Contact buscar(int index) {
        return contacts.get(index);
    }

    public void adicionar(Contact c) {
        contacts.add(c);
    }

    public void remover(int index) {
        contacts.remove(index);
    }

    public void atualizar(int index, Contact c) {
        contacts.set(index, c);
    }
}
