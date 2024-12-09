package br.com.catolica.RadioFM.Models;

import java.util.List;
import java.util.ArrayList;
import br.com.catolica.RadioFM.Enum.GeneroProgramacao;

public abstract class Programacao {
    protected String nome;
    protected String horario;
    protected GeneroProgramacao genero;
    protected List<Musica> musicas;

    public Programacao(String nome, String horario, GeneroProgramacao genero) {
        this.nome = nome;
        this.horario = horario;
        this.genero = genero;
        this.musicas = new ArrayList<>();
    }

    public abstract void iniciar();

    public void adicionarMusica(Musica musica) {
        if (musica != null) {
            musicas.add(musica);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public GeneroProgramacao getGenero() {
        return genero;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
