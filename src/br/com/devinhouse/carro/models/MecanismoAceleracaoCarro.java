package br.com.devinhouse.carro.models;

public class MecanismoAceleracaoCarro extends MecanismoAceleracao {
	
	public double acelerar(double velocidadeAtual) {
		System.out.println("Vrum vrum");
		return velocidadeAtual++;
	}
}

