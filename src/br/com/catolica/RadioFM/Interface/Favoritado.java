package br.com.catolica.RadioFM.Interface;

import br.com.catolica.RadioFM.Models.Programa;

interface Favoritado {
    void favoritarPrograma(Programa programa);
    void desfavoritarPrograma(Programa programa);
}

