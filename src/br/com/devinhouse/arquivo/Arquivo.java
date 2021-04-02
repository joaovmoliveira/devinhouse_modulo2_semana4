package br.com.devinhouse.arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Arquivo {
	public static void lerArquivo(String nomeArquivo) {
		try {
			FileInputStream file = new FileInputStream(nomeArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("arquivo não encontrado: " + nomeArquivo);
		}
	}
}
