package br.com.devinhouse.carro.models;

import br.com.devinhouse.carro.interfaces.Automovel;

public class Moto implements Automovel {
	private String modelo;
	private double velocidade;
	private MecanismoAceleracaoMoto mecanismoAceleracao;
	
	
	public Moto(String modelo, MecanismoAceleracaoMoto mecanismoAceleracaoMoto) {
		this.modelo = modelo;
		this.mecanismoAceleracao = mecanismoAceleracaoMoto;
	}
	
	@Override
	public void frear() {
		// ...
	}
	
	@Override
	public void acelerar() {
		double novaVelocidade = this.mecanismoAceleracao.acelerar(this.getVelocidade());
		this.setVelocidade(novaVelocidade);
	}
	
	@Override
	public void acenderFarol() {
		System.out.println("Farol da moto aceso.");
		
	}

	public double getVelocidade() {
		return velocidade;
	}

	private void setVelocidade(double novaVelocidade) {
		this.velocidade = novaVelocidade;
	}
	
	
}
