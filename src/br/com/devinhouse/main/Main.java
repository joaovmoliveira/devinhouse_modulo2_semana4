package br.com.devinhouse.main;

import br.com.devinhouse.banco.exceptions.SaldoInsuficienteException;
import br.com.devinhouse.banco.models.ContaCorrente;

public class Main {

	public static void main(String[] args) {
		// Arquivo.lerArquivo("teste.txt");

		ContaCorrente cc = new ContaCorrente("João Victor", "Oliveira", "1", 50);

		try {
			cc.sacar(100);
		} catch (SaldoInsuficienteException sie) {
			System.err.println(sie.getMessage());
		}
	}
}
