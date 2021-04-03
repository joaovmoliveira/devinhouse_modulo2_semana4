package br.com.devinhouse.jogo.personagens.classesjogador;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Jogador;

public class Paladino extends Jogador {
	public Paladino(String nome, char sexo, Arma arma) throws IllegalArgumentException {
		super(nome, sexo, 13, 18);
		if (arma.getNome().equals("Martelo") || arma.getNome().equals("Clava")) {
			super.setArma(arma);
		} else {
			throw new IllegalArgumentException("Paladino só pode utilizar Martelo ou Clava.");
		}
	}
}
