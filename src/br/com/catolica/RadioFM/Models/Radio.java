package br.com.catolica.RadioFM.Models;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public abstract class Radio {
    protected String nome;
    protected String frequencia;
    protected Map<String, Programa> programas;
    protected Set<Ouvinte> ouvintes;

    public Radio(String nome, String frequencia) {
        this.nome = nome;
        this.frequencia = frequencia;
        this.programas = new HashMap<>();
        this.ouvintes = new HashSet<>();
    }

    public abstract void transmitir();

    public void adicionarPrograma(Programa programa) {
        try {
            if (programa == null) {
                throw new IllegalArgumentException("Programa não pode ser nulo.");
            }
            programas.put(programa.getNome(), programa);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar programa: " + e.getMessage());
        }
    }

    public void adicionarOuvinte(Ouvinte ouvinte) {
        if (ouvinte == null) {
            System.out.println("Ouvinte inválido.");
        } else {
            ouvintes.add(ouvinte);
        }
    }

    public void listarProgramas() {
        System.out.println("Programas disponíveis:");
        for (String nomePrograma : programas.keySet()) {
            System.out.println("- " + nomePrograma);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getFrequencia() {
        return frequencia;
    }
}
