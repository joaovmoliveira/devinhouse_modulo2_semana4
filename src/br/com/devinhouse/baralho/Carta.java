package br.com.devinhouse.baralho;

import br.com.devinhouse.baralho.enums.Face;
import br.com.devinhouse.baralho.enums.Naipe;

public class Carta {
	private Face face;
	private Naipe naipe;
	
	public Carta(Face face, Naipe naipe) {
		this.face = face;
		this.naipe = naipe;
	}
	
	public String toString() {
		return face.getValor() + " de " + naipe;
	}
}

