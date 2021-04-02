package br.com.devinhouse.banco.models;

import br.com.devinhouse.banco.interfaces.Teste;
import br.com.devinhouse.banco.interfaces.Tributavel;

public class ContaCorrente extends Conta 
				implements Tributavel, Comparable<ContaCorrente> {
	private double limite;
	
	public ContaCorrente(String nome, String sobrenome, String cpf, double limite) {
		super(nome, sobrenome, cpf);
		this.limite = limite;
	}
	
	// exercicio 8 feito no tira-dúvidas
	@Override
	public String getTipo() {
		return "Conta Corrente";
	}
	
	@Override
	public int compareTo(ContaCorrente o) {
		if (this.getSaldo() > o.getSaldo()) {
			return -1;
		}
		if (this.getSaldo() < o.getSaldo()) {
			return 1;
		}
		return 0;
	}

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public double getSaldo() {
		return super.getSaldo() + this.limite;
	}
	
	public void teste(int teste) {
		System.out.println(teste);
	}
	
	@Override
	public void imprimeSaldo() {
		super.imprimeSaldo();
		System.out.printf("E possui R$ %.2f de limite.", this.limite);
	}
	
	@Override
	public double getValorImposto() {
		return super.getSaldo() * 0.01;
	}

}
