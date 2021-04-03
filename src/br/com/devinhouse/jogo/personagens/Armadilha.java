package br.com.devinhouse.jogo.personagens;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.interfaces.Atacante;

public class Armadilha implements Atacante {
	private int pontosDeAtaque;
	private Arma arma;
	
	public Armadilha() {		
		this.pontosDeAtaque = 5;
		this.arma = Arma.ARMADILHA;
	}
	
	@Override
	public void atacar(Personagem defensor) {
		int resultadoDado = this.rolarDado(10);
		if (resultadoDado == 1) {
			System.out.println("O ataque da armadilha pegou de rasp�o e voc� n�o sofreu dano.");
		} else {
			int poderAtaqueDesferido = this.pontosDeAtaque + resultadoDado + this.arma.getPoderDeAtaque();
			int danoSofrido = defensor.sofreDano(poderAtaqueDesferido, false);
			
			if (danoSofrido < 1) {
				System.out.println("A flecha pegou de rasp�o na armadura e voc� n�o sofreu dano!");
			} else {
				System.out.printf("Voc� sofreu %d de dano e agora possui %d pontos de vida.%n", 
						danoSofrido, defensor.getPontosDeSaude());				
			}
		}
	}
}
