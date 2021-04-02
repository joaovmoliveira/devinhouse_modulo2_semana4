package br.com.devinhouse.baralho;

import java.util.Random;

import br.com.devinhouse.baralho.enums.Face;
import br.com.devinhouse.baralho.enums.Naipe;

public class Baralho {
	private Carta[] deck;
	private int cartaTopo;
	
	public static final int NUMERO_CARTAS = 52;
	private static final Random rand = new Random();
	
	public Baralho() {
		this.deck = new Carta[NUMERO_CARTAS];
		this.cartaTopo = 0;
		
		Face[] faces = Face.values();
		Naipe[] naipes = Naipe.values();
		
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Carta(faces[i % faces.length], naipes[i / faces.length]);
		}
	}
	
	public void embaralhar() {
		this.cartaTopo = 0;
		
		for (int i = 0; i < this.deck.length; i++) {
			int j = Baralho.rand.nextInt(NUMERO_CARTAS);
			
			Carta temp = this.deck[i];
			this.deck[i] = this.deck[j];
			this.deck[j] = temp;
		}
	}
	
	public Carta darUmaCarta() {
		Carta carta = null;
		
		if (this.cartaTopo < this.deck.length) {
			carta = this.deck[this.cartaTopo++];
		}
		
		return carta;
	}

}
