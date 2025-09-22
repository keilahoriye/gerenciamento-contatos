CREATE DATABASE gerenciamento_contatos;

USE gerenciamento_contatos;

CREATE TABLE contatos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(150) NOT NULL UNIQUE,
	idade INT
);

ALTER TABLE contatos
ADD COLUMN data_nascimento DATE;

ALTER TABLE contatos
ADD COLUMN telefone VARCHAR(20) NOT NULL;

ALTER TABLE contatos
ADD COLUMN endereco VARCHAR(200) NOT NULL;