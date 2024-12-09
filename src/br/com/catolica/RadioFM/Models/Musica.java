package br.com.catolica.RadioFM.Models;

import br.com.catolica.RadioFM.Enum.GeneroMusica;

public class Musica {
    private String nome;
    private String artista;
    private int duracao;
    private GeneroMusica genero;

    public Musica(String nome, String artista, int duracao, GeneroMusica genero) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public GeneroMusica getGenero() {
        return genero;
    }
}
