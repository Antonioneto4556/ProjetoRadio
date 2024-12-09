package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.StatusTransmissao;
import br.com.catolica.RadioFM.Enum.GeneroProgramacao;
import java.util.ArrayList;
import java.util.List;

public class Programa extends Programacao {
    private String descricao;
    private int audiencia;
    private StatusTransmissao statusTransmissao;
    private List<Musica> musicas;

    public Programa(String nome, String horario, GeneroProgramacao genero, String descricao) {
        super(nome, horario, genero);
        this.descricao = descricao;
        this.audiencia = 0;
        this.statusTransmissao = StatusTransmissao.PAUSADO;
        this.musicas = new ArrayList<>();
    }

    @Override
    public void iniciar() {
        if (statusTransmissao == StatusTransmissao.PAUSADO) {
            statusTransmissao = StatusTransmissao.EM_ANDAMENTO;
            System.out.println("Iniciando o programa " + nome + " às " + horario);
        } else {
            System.out.println("O programa já está em andamento ou foi interrompido.");
        }
    }

    public void pausar() {
        if (statusTransmissao == StatusTransmissao.EM_ANDAMENTO) {
            statusTransmissao = StatusTransmissao.PAUSADO;
            System.out.println("Programa " + nome + " foi pausado.");
        } else {
            System.out.println("Não é possível pausar um programa que não está em andamento.");
        }
    }

    public void interromper() {
        statusTransmissao = StatusTransmissao.INTERROMPIDO;
        System.out.println("Programa " + nome + " foi interrompido.");
    }

    public String getDescricao() {
        return "Programa: " + nome + "\nDescrição: " + descricao + "\nStatus: " + statusTransmissao;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void incrementarAudiencia() {
        audiencia++;
        System.out.println("Audiência do programa " + nome + " aumentou para " + audiencia);
    }

    public List<String> listarMusicas() {
        List<String> titulos = new ArrayList<>();
        for (Musica musica : musicas) {
            titulos.add(musica.getNome() + " - " + musica.getArtista());
        }
        return titulos;
    }

    public void adicionarMusica(Musica musica) {
        if (musica != null && !musicas.contains(musica)) {
            musicas.add(musica);
            System.out.println("Música " + musica.getNome() + " adicionada ao programa " + nome);
        } else {
            System.out.println("Música inválida ou já adicionada.");
        }
    }

    public StatusTransmissao getStatusTransmissao() {
        return statusTransmissao;
    }

    public String mostrarDetalhes() {
        return "Detalhes do Programa:\n" +
                "Nome: " + nome + "\n" +
                "Horário: " + horario + "\n" +
                "Gênero: " + genero + "\n" +
                "Descrição: " + descricao + "\n" +
                "Status: " + statusTransmissao + "\n" +
                "Audiência: " + audiencia + "\n" +
                "Músicas: " + listarMusicas();
    }
}
