package com.example.contact.Services;

import com.example.contact.Models.Contact;
import java.util.List;

import com.example.contact.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listarContatos() {
        return contactRepository.findAll();
    }

    public Contact cadastrarContato(Contact c) {
        return contactRepository.save(c);
    }

    public Contact buscar(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void excluirContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado com id: " + id);
        }
        contactRepository.deleteById(id);
    }

    public Contact atualizarContact(Long id, Contact contactAtualizado) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contact.setNome(contactAtualizado.getNome());
            contact.setTelefone(contactAtualizado.getTelefone());
            contact.setEmail(contactAtualizado.getEmail());
            contact.setIdade(contactAtualizado.getIdade());
            contact.setDataNascimento(contactAtualizado.getDataNascimento());
            contact.setEndereco(contactAtualizado.getEndereco()); // <-- novo campo
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException("Contato não encontrado com id: " + id);
        }
    }

}
