package br.com.devinhouse.baralho;

public enum Naipe {
	COPAS(1, "Copas"),
	ESPADAS(2, "Espadas"),
	OUROS(3, "Ouros"),
	PAUS(4, "Paus");
	
	private int id;
	private String valor;
	
	Naipe(int id, String valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public int getId() {
		return this.id;
	}

}
