package br.com.devinhouse.carro.models;

public class MecanismoAceleracaoMoto {
	
	public double acelerar(double velocidadeAtual) {
		System.out.println("Brém Brém");
		return velocidadeAtual++;
	}
}
