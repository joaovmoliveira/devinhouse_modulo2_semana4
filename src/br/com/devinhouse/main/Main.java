package br.com.devinhouse.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.devinhouse.banco.models.ContaCorrente;
import br.com.devinhouse.calculadora.Calculadora;

public class Main {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente("Jo�o", "Mendes", "1", 50.0);
		try {
			cc.sacar(10);
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		
		
		/*
		 * Scanner sc = new Scanner(System.in); boolean repetir = true;
		 * 
		 * try { do { try { System.out.println("Favor inserir um numerador:"); int
		 * numerador = sc.nextInt();
		 * 
		 * System.out.println("Favor inserir um denominador:"); int denominador =
		 * sc.nextInt();
		 * 
		 * int resultado = Calculadora.dividir(numerador, denominador);
		 * 
		 * System.out.printf("Resultado: %d / %d = %d%n", numerador, denominador,
		 * resultado); repetir = false; } catch (InputMismatchException ime) {
		 * sc.nextLine(); System.err.println("Exce��o: " + ime);
		 * System.out.println("Favor inserir um valor inteiro v�lido."); } catch
		 * (ArithmeticException ae) { System.err.println("Exce��o: " + ae);
		 * System.out.println("N�o � poss�vel dividir por zero."); } } while (repetir);
		 * } finally { sc.close(); }
		 * 
		 * 
		 * System.out.println("fora do try-catch");
		 */
		
		
	}

}
