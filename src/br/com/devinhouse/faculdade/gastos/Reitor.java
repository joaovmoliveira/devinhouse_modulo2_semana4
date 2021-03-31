package br.com.devinhouse.faculdade.gastos;

public class Reitor extends Funcionario {
	
	@Override
	public String getInfo() {
		return String.format("%s%n… reitor.", 
				super.getInfo());
	}
	
	@Override
	public double getGastos() {
		return this.getSalario();
	}
}

