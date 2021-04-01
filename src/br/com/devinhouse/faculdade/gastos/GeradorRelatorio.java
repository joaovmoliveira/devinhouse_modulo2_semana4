package br.com.devinhouse.faculdade.gastos;

public class GeradorRelatorio {
	public static void adiciona(Funcionario f) {
		System.out.println(f.getGastos());
		System.out.println(f.getInfo());
		if (f instanceof Professor) {
			Professor prof = (Professor) f;
			System.out.println(prof.getQtdDisciplinas());
		}
	}

}
