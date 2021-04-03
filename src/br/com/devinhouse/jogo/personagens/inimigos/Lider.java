package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Inimigo;

public class Lider extends Inimigo {	
	private static final int SAUDE_MAXIMA_LIDER = 200;

	public Lider() {
		super(15, 15, Lider.SAUDE_MAXIMA_LIDER, Arma.MACHADO_DUPLO);
	}
}
