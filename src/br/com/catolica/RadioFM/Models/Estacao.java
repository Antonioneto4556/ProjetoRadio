package br.com.catolica.RadioFM.Models;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Estacao extends Radio {

    private Map<String, Programa> programas;
    private Set<Ouvinte> ouvintes;

    public Estacao(String nome, String frequencia) {
        super(nome, frequencia);
        this.programas = new HashMap<>();
        this.ouvintes = new HashSet<>();
    }

    @Override
    public void transmitir() {
        System.out.println("Transmitindo na estação " + nome);
        if (programas.isEmpty()) {
            System.out.println("Nenhum programa disponível.");
        } else {
            for (Programa p : programas.values()) {
                System.out.println("Transmitindo o programa: " + p.getNome() + " | Audiência: " + p.getAudiencia() + " | Status: " + p.getStatusTransmissao());
            }
        }
    }

    public void adicionarPrograma(Programa programa) {
        if (programa != null) {
            if (!programas.containsKey(programa.getNome())) {
                programas.put(programa.getNome(), programa);
                System.out.println("Programa " + programa.getNome() + " adicionado.");
            } else {
                System.out.println("Já existe um programa com o nome " + programa.getNome() + ".");
            }
        } else {
            System.out.println("Programa inválido.");
        }
    }

    public void adicionarOuvinte(Ouvinte ouvinte) {
        if (ouvinte != null) {
            if (!ouvintes.contains(ouvinte)) {
                ouvintes.add(ouvinte);
                System.out.println("Ouvinte " + ouvinte.getNome() + " adicionado.");

                for (Programa programa : programas.values()) {
                    programa.incrementarAudiencia();
                }
            } else {
                System.out.println("Ouvinte " + ouvinte.getNome() + " já está registrado.");
            }
        } else {
            System.out.println("Ouvinte inválido.");
        }
    }

    public Map<String, Programa> getProgramas() {
        return programas;
    }

    public Set<Ouvinte> getOuvintes() {
        return ouvintes;
    }

    public void removerPrograma(Programa programa) {
        if (programa != null && programas.containsKey(programa.getNome())) {
            programas.remove(programa.getNome());
            System.out.println("Programa " + programa.getNome() + " removido.");
        } else {
            System.out.println("Programa não encontrado.");
        }
    }


    public void listarProgramas() {
        if (programas.isEmpty()) {
            System.out.println("Nenhum programa disponível.");
        } else {
            for (Programa programa : programas.values()) {
                System.out.println(programa.mostrarDetalhes());
            }
        }
    }
}
