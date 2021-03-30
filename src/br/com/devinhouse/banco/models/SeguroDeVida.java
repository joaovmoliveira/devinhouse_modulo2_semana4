package br.com.devinhouse.banco.models;

import br.com.devinhouse.banco.interfaces.Tributavel;

public class SeguroDeVida implements Tributavel {
	private double valor;
	private Cliente titular;
	private int numeroApolice;
	
	public SeguroDeVida(String nomeTitular, String sobrenomeTitular, 
			String cpfTitular, double valor) {
		this.valor = valor;
		this.titular = new Cliente(nomeTitular, sobrenomeTitular, cpfTitular);
		this.numeroApolice = (int) (Math.random() * (1000 - 1) + 1);
	}
	
	// ...
	
	@Override
	public double getValorImposto() {
		return 42 + this.valor * 0.02;
	}

}
