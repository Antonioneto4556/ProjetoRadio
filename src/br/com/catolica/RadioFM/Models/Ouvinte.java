package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.CargoPessoa;
import br.com.catolica.RadioFM.Interface.Interativo;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Ouvinte extends Pessoa implements Interativo {
    private Set<Programa> programasFavoritos;
    private List<String> mensagensRecebidas;

    public Ouvinte(String nome, int idade, CargoPessoa cargo) {
        super(nome, idade, cargo);
        this.programasFavoritos = new HashSet<>();
        this.mensagensRecebidas = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println(nome + " enviou a mensagem: " + mensagem);
    }

    public void receberMensagem(String mensagem) {
        mensagensRecebidas.add(mensagem);
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }

    public List<String> getMensagensRecebidas() {
        return mensagensRecebidas;
    }

    @Override
    public void interagir() {
        System.out.println(nome + " está ouvindo a estação.");
    }

    public void favoritarPrograma(Programa programa) {
        if (programa != null) {
            programasFavoritos.add(programa);
            System.out.println(nome + " favoritou o programa " + programa.getNome());
        }
    }

    public void desfavoritarPrograma(Programa programa) {
        programasFavoritos.remove(programa);
        System.out.println(nome + " desfavoritou o programa " + programa.getNome());
    }

    public Set<Programa> getProgramasFavoritos() {
        return programasFavoritos;
    }
}
