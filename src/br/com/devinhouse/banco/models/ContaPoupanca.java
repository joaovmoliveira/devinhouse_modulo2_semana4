package br.com.devinhouse.banco.models;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(String nome, String sobrenome, String cpf, double saldo) {
		super(nome, sobrenome, cpf, saldo);
	}

	// exercicio 8 feito no tira-dúvidas
	@Override
	public String getTipo() {
		return "Conta Poupança";
	}

}
