package com.example.contact.Models;

public class Contact {
    private String nome;
    private String telefone;
    private String email;
    private int index;

    public Contact(String nome, String telefone, String email, int index) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.index = index;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getIndex() {
        return this.index;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}