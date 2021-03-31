package br.com.devinhouse.carro.models;

import br.com.devinhouse.carro.interfaces.Automovel;

public class Carro implements Automovel {
	private String modelo;
	private double velocidade;
	private String cor;
	private int qtdPortas;
	private MecanismoAceleracaoCarro mecanismoAceleracao;
	
	public Carro(String modelo, MecanismoAceleracaoCarro mecanismoAceleracao, String cor, int qtdPortas) {
		this.modelo = modelo;
		this.mecanismoAceleracao = mecanismoAceleracao;
		this.cor = cor;
		this.qtdPortas = qtdPortas;
		this.velocidade = 0;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public double getVelocidade() {
		return this.velocidade;
	}
	
	private void setVelocidade(double novaVelocidade) {
		this.velocidade = novaVelocidade;
	}
	
	@Override
	public void acelerar() {
		double novaVelocidade = this.mecanismoAceleracao.acelerar(this.getVelocidade());
		this.setVelocidade(novaVelocidade);
	}
	
	@Override
	public void frear() {
		// ...
	}
	
	@Override
	public void acenderFarol() {
		System.out.println("Farol de carro aceso.");
	}
	
	public void buzinar() {
		System.out.println("BIBIII");
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
