package br.com.devinhouse.banco.models;

import br.com.devinhouse.banco.interfaces.Tributavel;

public class ManipuladorDeTributaveis {
	private double total;
	
	public void calculaImpostos(Tributavel[] produtos) {		
		for (Tributavel prod : produtos) {
			total += prod.getValorImposto();
		}
	}
	
	public double getTotal() {
		return this.total;
	}
}
