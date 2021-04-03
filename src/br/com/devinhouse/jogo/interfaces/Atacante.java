package br.com.devinhouse.jogo.interfaces;

import br.com.devinhouse.jogo.personagens.Personagem;

public interface Atacante {
	void atacar(Personagem defensor);
	
	default int rolarDado(int qtdLadosDado) {
		return (int) (Math.random() * (qtdLadosDado - 1) + 1);
	}
}
