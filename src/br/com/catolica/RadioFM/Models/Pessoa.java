package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.CargoPessoa;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected CargoPessoa cargo;

    public Pessoa(String nome, int idade, CargoPessoa cargo) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (idade <= 0) {
            throw new IllegalArgumentException("A idade deve ser maior que zero.");
        }
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
    }

    public abstract void interagir();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("A idade deve ser maior que zero.");
        }
        this.idade = idade;
    }

    public CargoPessoa getCargo() {
        return cargo;
    }
}
