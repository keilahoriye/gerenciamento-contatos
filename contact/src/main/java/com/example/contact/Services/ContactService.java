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
        for (Contact c: contacts) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return null;
    }

    public boolean adicionar(Contact c) {
        if (c.getNome() == null || c.getEmail() == null || c.getTelefone() == null) {
            return false;
        }
        contacts.add(c);
        return true;
    }

    public void remover(int index) {
        contacts.remove(index);
    }

    public void atualizar(int index, Contact c) {
        contacts.set(index, c);
    }
}
