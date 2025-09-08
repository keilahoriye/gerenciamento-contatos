package com.example.contact.Controllers;

import com.example.contact.Models.Contact;
import com.example.contact.Services.ContactService;
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
    public Contact buscar(@PathVariable int index) {
        return contactService.buscar(index);
    }

    @PostMapping
    public void adicionar(@RequestBody Contact contato) {
        contactService.adicionar(contato);
    }

    @DeleteMapping("/{index}")
    public void remover(@PathVariable int index) {
        contactService.remover(index);
    }

    @PutMapping("/{index}")
    public void atualizar(@PathVariable int index, @RequestBody Contact c) {
        contactService.atualizar(index, c);
    }
}
