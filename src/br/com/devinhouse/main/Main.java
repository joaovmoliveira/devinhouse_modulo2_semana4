package br.com.devinhouse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.devinhouse.banco.exceptions.SaldoInsuficienteException;
import br.com.devinhouse.banco.models.Conta;
import br.com.devinhouse.banco.models.ContaCorrente;

public class Main {

	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente("João Victor", "Oliveira", "1", 150.0);
		ContaCorrente c2 = new ContaCorrente("Jéssica", "Treméa", "2", 50.0);
		ContaCorrente c3 = new ContaCorrente("Hugo", "Oliveira", "3", 30.0);
		ContaCorrente c4 = new ContaCorrente("Winston", "McCall", "4", 500.0);
		ContaCorrente c5 = new ContaCorrente("Shigeru", "Miyamoto", "5", 10.0);

		List<ContaCorrente> listaDeContas = new ArrayList<ContaCorrente>();
		listaDeContas.add(c1);
		listaDeContas.add(c2);
		listaDeContas.add(c3);
		listaDeContas.add(c4);
		listaDeContas.add(c5);

		/*
		 * System.out.println(listaDeContas.size());
		 * 
		 * for (int i = 0; i < listaDeContas.size(); i++) { ContaCorrente conta =
		 * listaDeContas.get(i); System.out.println(conta.getSaldo()); }
		 * 
		 * Collections.sort(listaDeContas);
		 * 
		 * System.out.println("Lista ordenada: ");
		 * 
		 * for (ContaCorrente conta : listaDeContas) {
		 * System.out.println(conta.getSaldo()); }
		 */
		

		/*
		 * List<String> lista = new ArrayList<>(); lista.add("João"); lista.add("Hugo");
		 * lista.add("Jessica"); System.out.println(lista);
		 * 
		 * Collections.sort(lista);
		 * 
		 * System.out.println(lista);
		 */
		
		
		Integer[][] arrayDeInteiros = {
				{1, 3}, 
				{2, 6}, 
				{3, 9}
			};
		
		System.out.println(Arrays.deepToString(arrayDeInteiros[0]));
	}
}
