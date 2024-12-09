package br.com.catolica.RadioFM.Interface;

import br.com.catolica.RadioFM.Models.Programa;

public interface Gerenciavel {
    void adicionarPrograma(Programa programa);
    void removerPrograma(String nomePrograma);
}
