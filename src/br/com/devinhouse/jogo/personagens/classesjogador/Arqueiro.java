package br.com.devinhouse.jogo.personagens.classesjogador;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Jogador;

public class Arqueiro extends Jogador {
	public Arqueiro(String nome, char sexo, Arma arma) throws IllegalArgumentException {
		super(nome, sexo, 18, 13);
		if (arma.getNome().equals("Arco-e-flecha") || arma.getNome().equals("Besta")) {
			super.setArma(arma);
		} else {
			throw new IllegalArgumentException("Arqueiro só pode utilizar Arco-e-flecha ou Besta.");
		}
	}

}
