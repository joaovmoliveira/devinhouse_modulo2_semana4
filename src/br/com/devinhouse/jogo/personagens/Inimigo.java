package br.com.devinhouse.jogo.personagens;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.interfaces.Atacante;

public abstract class Inimigo extends Personagem implements Atacante {
	private Arma arma;
	
	public Inimigo(int pontosDeAtaque, int pontosDeDefesa, int pontosDeSaude, Arma arma) {
		super(pontosDeAtaque, pontosDeDefesa, pontosDeSaude);
		this.arma = arma;
	}
	
	@Override
	public void atacar(Personagem defensor) {
		int resultadoDado = this.rolarDado(20);
		int danoSofrido;
		
		if (resultadoDado == 1) {
			System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
		} else {
			int poderAtaqueDesferido = this.getPontosDeAtaque() + resultadoDado + this.arma.getPoderDeAtaque();
			
			if (resultadoDado == 20) {
				danoSofrido = defensor.sofreDano(poderAtaqueDesferido, true);
				System.out.print("O inimigo acertou um ataque crítico! ");
			} else {
				danoSofrido = defensor.sofreDano(poderAtaqueDesferido, false);
				System.out.print("O inimigo atacou! ");
			}
			
			if (danoSofrido < 1) {
				System.out.println("Você bloqueou o ataque do inimigo e não sofreu nenhum dano!");
			} else {
				System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.%n", 
						danoSofrido, defensor.getPontosDeSaude());				
			}
		}
	}
}
