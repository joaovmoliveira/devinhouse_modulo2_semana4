package br.com.devinhouse.jogo.personagens;

import br.com.devinhouse.jogo.enums.Arma;
import br.com.devinhouse.jogo.enums.Motivacao;
import br.com.devinhouse.jogo.interfaces.Atacante;

public abstract class Jogador extends Personagem implements Atacante {
	private String nome;
	private Motivacao motivacao;
	private char sexo;
	private Arma arma;
	public static final int SAUDE_MAXIMA_JOGADOR = 200;
	
	public Jogador(String nome, char sexo, int pontosDeAtaque, int pontosDeDefesa)
			throws IllegalArgumentException {
		super(pontosDeAtaque, pontosDeDefesa, Jogador.SAUDE_MAXIMA_JOGADOR);
		
		if (nome.isBlank() || nome.isEmpty()) {
			throw new IllegalArgumentException("Necessário definir um nome.");
		} else {
			this.nome = nome;
		}
		
		if (sexo == 'M' || sexo == 'F') {
			this.sexo = sexo;
		} else {
			throw new IllegalArgumentException("Digite M ou F para o sexo.");
		}
	}

	public Motivacao getMotivacao() {
		return this.motivacao;
	}

	public void setMotivacao(Motivacao motivacao) {
		this.motivacao = motivacao;
	}
	
	public Arma getArma() {
		return this.arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public char getSexo() {
		return this.sexo;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public void atacar(Personagem defensor) {
		int resultadoDado = this.rolarDado(20);
		int danoInfligido;
		
		if (resultadoDado == 1) {
			System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
		} else {
			int poderAtaqueDesferido = this.getPontosDeAtaque() + resultadoDado + this.arma.getPoderDeAtaque();
			
			if (resultadoDado == 20) {
				danoInfligido = defensor.sofreDano(poderAtaqueDesferido, true);
				System.out.print("Você acertou um ataque crítico!");
			} else {
				danoInfligido = defensor.sofreDano(poderAtaqueDesferido, false);
			}
			
			if (danoInfligido < 1) {
				System.out.println("O inimigo bloqueou seu ataque e não sofreu dano algum!");
			} else {
				System.out.printf("Você atacou %s e causou %d de dano no inimigo!%n", 
						this.arma.getMensagemDeAtaque(), danoInfligido);
			}
		}
	}
}
