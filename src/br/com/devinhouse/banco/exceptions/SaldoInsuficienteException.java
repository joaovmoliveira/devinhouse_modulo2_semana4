package br.com.devinhouse.banco.exceptions;

public class SaldoInsuficienteException extends Exception {
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
