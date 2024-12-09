package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.CargoPessoa;
import br.com.catolica.RadioFM.Interface.Interativo;

import java.util.ArrayList;
import java.util.List;

public class Apresentador extends Pessoa implements Interativo {
    private Programa programaAtualmenteApresentado;
    private List<String> interacoes;

    public Apresentador(String nome, int idade, CargoPessoa cargo) {
        super(nome, idade, cargo);
        this.interacoes = new ArrayList<>();
    }

    @Override
    public void interagir() {
        System.out.println(nome + " está apresentando um programa.");
    }

    public void apresentarPrograma(Programa programa) {
        if (programa != null) {
            programaAtualmenteApresentado = programa;
            System.out.println(nome + " está apresentando o programa: " + programa.getNome());
            programa.iniciar();
        } else {
            System.out.println("Não foi possível apresentar o programa. Programa inválido.");
        }
    }

    public void interagirComOuvinte(Ouvinte ouvinte) {
        if (ouvinte != null) {
            String mensagem = "Olá, " + ouvinte.getNome() + "! Obrigado por participar.";
            ouvinte.receberMensagem(mensagem);
            interacoes.add(nome + " interagiu com o ouvinte " + ouvinte.getNome());
            System.out.println(nome + " enviou a mensagem ao ouvinte " + ouvinte.getNome());
        } else {
            System.out.println("Ouvinte inválido para interação.");
        }
    }

    public void exibirInteracoes() {
        System.out.println("Interações realizadas:");
        for (String interacao : interacoes) {
            System.out.println(interacao);
        }
    }

    public void exibirInformacoesDoPrograma() {
        if (programaAtualmenteApresentado != null) {
            System.out.println("Informações sobre o programa " + programaAtualmenteApresentado.getNome() + ":");
            System.out.println("Descrição: " + programaAtualmenteApresentado.getDescricao());
            System.out.println("Horário: " + programaAtualmenteApresentado.getHorario());
            System.out.println("Status: " + programaAtualmenteApresentado.getStatusTransmissao());
        } else {
            System.out.println("Nenhum programa está sendo apresentado.");
        }
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Apresentador " + nome + " enviou a mensagem: " + mensagem);
    }
}
