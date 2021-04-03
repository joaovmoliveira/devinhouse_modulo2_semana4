package br.com.devinhouse.jogo.personagens.inimigos;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.personagens.Inimigo;

public class Alquimista extends Inimigo {	
	private static final int SAUDE_MAXIMA_ALQUIMISTA = 100;

	public Alquimista() {
		super(15, 10, Alquimista.SAUDE_MAXIMA_ALQUIMISTA, Arma.CAJADO);
	}
}
