package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.CargoPessoa;
import br.com.catolica.RadioFM.Interface.Gerenciavel;
import br.com.catolica.RadioFM.Interface.Transmicao;

public class Administrador extends Pessoa implements Gerenciavel, Transmicao {
    private Estacao estacaoGerenciada;

    public Administrador(String nome, int idade, CargoPessoa cargo, Estacao estacaoGerenciada) {
        super(nome, idade, cargo);
        this.estacaoGerenciada = estacaoGerenciada;
    }

    @Override
    public void interagir() {
        System.out.println(nome + " está gerenciando a estação.");
    }

    @Override
    public void adicionarPrograma(Programa programa) {
        estacaoGerenciada.adicionarPrograma(programa);
    }

    @Override
    public void removerPrograma(String nomePrograma) {
        Programa programa = estacaoGerenciada.getProgramas().get(nomePrograma);  // Buscar o programa pelo nome
        if (programa != null) {
            estacaoGerenciada.removerPrograma(programa);  // Remover o programa utilizando o objeto encontrado
            System.out.println("Programa " + nomePrograma + " removido.");
        } else {
            System.out.println("Programa não encontrado.");
        }
    }

    @Override
    public void iniciarTransmissao() {
        if (estacaoGerenciada.getProgramas().isEmpty()) {
            System.out.println("Nenhum programa para transmitir.");
        } else {
            for (Programa programa : estacaoGerenciada.getProgramas().values()) {
                programa.iniciar();
            }
            System.out.println("Transmissão iniciada.");
        }
    }

    @Override
    public void interromperTransmissao() {
        for (Programa programa : estacaoGerenciada.getProgramas().values()) {
            programa.interromper();
        }
        System.out.println("Transmissão interrompida.");
    }

    public void pausarTransmissao() {
        for (Programa programa : estacaoGerenciada.getProgramas().values()) {
            programa.pausar();
        }
        System.out.println("Transmissão pausada.");
    }

    public void listarProgramas() {
        if (estacaoGerenciada.getProgramas().isEmpty()) {
            System.out.println("Não há programas cadastrados na estação.");
        } else {
            System.out.println("Programas na estação " + estacaoGerenciada.getNome() + ":");
            for (Programa programa : estacaoGerenciada.getProgramas().values()) {
                System.out.println("Nome: " + programa.getNome() + " - Status: " + programa.getStatusTransmissao());
            }
        }
    }

    public void adicionarOuvinte(Ouvinte ouvinte) {
        estacaoGerenciada.adicionarOuvinte(ouvinte);
    }

    public void removerOuvinte(Ouvinte ouvinte) {
        if (estacaoGerenciada.getOuvintes().contains(ouvinte)) {
            estacaoGerenciada.getOuvintes().remove(ouvinte);
            System.out.println("Ouvinte " + ouvinte.getNome() + " removido.");
        } else {
            System.out.println("Ouvinte não encontrado.");
        }
    }

    public void configurarEstacao(String novoNome, String novaFrequencia) {
        estacaoGerenciada = new Estacao(novoNome, novaFrequencia);
        System.out.println("Estação configurada: " + novoNome + " - Frequência: " + novaFrequencia);
    }
}
