package com.example.contact.Controllers;

import com.example.contact.Models.Contact;
import com.example.contact.Services.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/contatos")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>>listar() {
        return ResponseEntity.ok(contactService.listarContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> buscar(@PathVariable Long id) {
        Contact contato = contactService.buscar(id);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contact> cadastrar(@Valid @RequestBody Contact c) {
        Contact salvo = contactService.cadastrarContato(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> atualizar(@PathVariable Long id, @Valid @RequestBody Contact contactAtualizado) {
        try {
            Contact atualizado = contactService.atualizarContact(id, contactAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            contactService.excluirContact(id);
            return ResponseEntity.ok("Contato removido com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
