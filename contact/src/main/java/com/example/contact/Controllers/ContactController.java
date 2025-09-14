package com.example.contact.Controllers;

import com.example.contact.Models.Contact;
import com.example.contact.Services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/contatos")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getContatos() {
        return contactService.listar();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Contact> buscar(@PathVariable int index) {
        Contact c = contactService.buscar(index);
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Contact> adicionar(@RequestBody Contact contato) {
        boolean sucesso = contactService.adicionar(contato);
        if (!sucesso) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> remover(@PathVariable int index) {
        contactService.remover(index);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{index}")
    public void atualizar(@PathVariable int index, @RequestBody Contact c) {
        contactService.atualizar(index, c);
    }
}
