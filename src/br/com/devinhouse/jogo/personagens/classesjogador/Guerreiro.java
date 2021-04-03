package br.com.devinhouse.jogo.personagens.classesjogador;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Jogador;

public class Guerreiro extends Jogador {
	public Guerreiro(String nome, char sexo, Arma arma) throws IllegalArgumentException {
		super(nome, sexo, 15, 15);
		if (arma.getNome().equals("Espada") || arma.getNome().equals("Machado")) {
			super.setArma(arma);
		} else {
			throw new IllegalArgumentException("Guerreiro só pode utilizar Espada ou Machado.");
		}	
	}
}
