package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Inimigo;

public class Armeiro extends Inimigo {
	private static final int SAUDE_MAXIMA_ARMEIRO = 100;
	
	public Armeiro() {
		super(10, 15, Armeiro.SAUDE_MAXIMA_ARMEIRO, Arma.ESPADA);
	}
}
