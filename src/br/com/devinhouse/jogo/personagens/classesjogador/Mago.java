package br.com.devinhouse.jogo.personagens.classesjogador;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Jogador;

public class Mago extends Jogador {
	public Mago(String nome, char sexo, Arma arma) throws IllegalArgumentException {
		super(nome, sexo, 19, 11);
		if (arma.getNome().equals("Cajado") || arma.getNome().equals("Livro de magias")) {
			super.setArma(arma);
		} else {
			throw new IllegalArgumentException("Mago só pode utilizar Cajado ou Livro de magias.");
		}
	}

}
