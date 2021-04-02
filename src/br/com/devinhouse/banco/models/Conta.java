package br.com.devinhouse.banco.models;

import br.com.devinhouse.banco.exceptions.SaldoInsuficienteException;
import br.com.devinhouse.banco.exceptions.ValorNegativoException;

public abstract class Conta {
	private Cliente titular;
	private double saldo;
	private boolean ativa;

	public Conta(String nomeTitular, String sobrenomeTitular, String cpfTitular) {
		this.titular = new Cliente(nomeTitular, sobrenomeTitular, cpfTitular);
	}

	public Conta(String nomeTitular, String sobrenomeTitular, String cpfTitular, double saldoInicial) {
		this(nomeTitular, sobrenomeTitular, cpfTitular);
		this.saldo = saldoInicial;
	}

	public abstract String getTipo(); // exercicio 8 feito no tira-d�vidas

	public void depositar(double valor) throws ValorNegativoException {
		if (valor <= 0) {
			throw new ValorNegativoException("Valor para dep�sito deve ser positivo.");
		}
		this.saldo += valor;
		System.out.printf("Valor de %.2f depositado com sucesso!%n", valor);
	}

	public final void teste(String teste) {
		System.out.println(teste);
	}

	public void sacar(double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente para sacar R$" + valor + ".");
		}
		this.saldo -= valor;
	}

	public void transferir(Conta destino, double valor) 
			throws SaldoInsuficienteException, ValorNegativoException, NullPointerException {
		this.sacar(valor);
		destino.depositar(valor);
	}

	/*
	 * public boolean transferir(Conta origem, Conta destino, double valor) { if
	 * (origem.sacar(valor)) { destino.depositar(valor); return true; } return
	 * false; }
	 */

	public double getSaldo() {
		return this.saldo;
	}

	public boolean isAtiva() {
		return this.ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public String ativaToString() {
		if (this.ativa) {
			return "Ativa";
		} else {
			return "Inativa";
		}
	}

	public void imprimeSaldo() {
		System.out.printf("O cliente %s %s possui R$ %.2f de saldo.%n", this.titular.nome, this.titular.sobrenome,
				this.saldo);
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s.%n%s: %.2f.%n%s: %s.", "Nome do titular", this.titular.nome,
				this.titular.sobrenome, "Saldo", this.saldo, "Conta ativa", (this.ativa) ? "Ativa" : "Inativa");
	}

	/*
	 * @Override public Object clone() { try { return (Conta) super.clone(); } catch
	 * (CloneNotSupportedException e) { return new Conta(this.titular.nome,
	 * this.titular.sobrenome, this.titular.cpf, this.saldo); } }
	 */

}
