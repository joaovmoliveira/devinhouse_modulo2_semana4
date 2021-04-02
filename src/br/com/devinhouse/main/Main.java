package br.com.devinhouse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.devinhouse.banco.exceptions.SaldoInsuficienteException;
import br.com.devinhouse.banco.exceptions.ValorNegativoException;
import br.com.devinhouse.banco.models.Conta;
import br.com.devinhouse.banco.models.ContaCorrente;
import br.com.devinhouse.baralho.Baralho;

public class Main {
	private static final int NUMERO_JOGADORES = 4;

	public static void main(String[] args) {
		Baralho baralho = new Baralho();
		baralho.embaralhar();

		String formato = "%-19s";

		for (int i = 1; i <= NUMERO_JOGADORES; i++) {
			System.out.printf(formato, "Jogador " + i);
		}

		System.out.println("");

		for (int i = 1; i <= Baralho.NUMERO_CARTAS; i++) {
			System.out.printf(formato, baralho.darUmaCarta());

			if (i % 4 == 0) {
				System.out.println();
			}
		}
		
		
		// primeira metade da aula de reforço:
		// validação dos métodos sacar, depositar e transferir com exceções
		
		ContaCorrente cc = new ContaCorrente("João Victor", "Oliveira", "1", 50.0);
		ContaCorrente cc2 = new ContaCorrente("Guilherme", "Noronha", "2", 150.0);

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite valor para depósito:");
		try {
			double valorDeposito = Double.parseDouble(sc.nextLine());
			cc.depositar(valorDeposito);
			System.out.println("Favor inserir valor a ser transferido:");
			double valorTransferencia = Double.parseDouble(sc.nextLine());
			cc.transferir(cc2, valorTransferencia);
		} catch (ValorNegativoException vne) {
			System.err.println(vne.getMessage());
		} catch (SaldoInsuficienteException sie) {
			System.err.format("Saldo insuficiente na conta de origem: R$ %.2f.", cc.getSaldo());
		} catch (NumberFormatException nfe) {
			System.err.println("Favor inserir valor numérico.");
		} catch (NullPointerException npe) {
			System.err.println("Não foi possível realizar a transferência. Contate o administrador dos sistema.");
		}

	}
}
