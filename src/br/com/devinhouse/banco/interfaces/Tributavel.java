package br.com.devinhouse.banco.interfaces;

public interface Tributavel extends Teste, OutroTeste {
	double getValorImposto();
	
	default double teste() {
		return 0;
	};
}
